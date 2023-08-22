<template>
  <div class="pet-card">
    <img :src="photo" alt="Pet Photo" class="pet-photo" />
    <!-- <button>Update Photo</button> -->
    <label v-if="isLoggedIn" for="image-upload">Update Photo:
      <CloudinaryWidget :animalId="animalId" @photo-uploaded="updatePhoto" />
    </label>
    <div class="pet-info">
      <h2>{{ animalName }}</h2>
      <p>Type: {{ animalType }}</p>
      <p>Gender: {{ gender }}</p>
      <p>Age: {{ age }}</p>
      <p>Description: {{ description }}</p>
      <p>Breed: {{ breed }}</p>
      <p v-if="isAdoptable">Status: Adoptable</p>
      <p v-else>Status: Not Adoptable</p>
      <slot></slot>
    </div>
    <div class="walk-status" v-if="animalType === 'Dog'">
      <p>On a Walk: {{ isOnWalk ? "Yes" : "No" }}</p>
      <button v-if="isLoggedIn" @click="handleToggleWalkAndModalVisibility">{{ isOnWalk ? "End Walk" : "Start Walk" }}</button>
          <Modal
      v-if="isModalVisible"
      @close="closeModal"/>
    </div>
  </div>
</template>
<script>
import Modal from './Modal.vue';
import CloudinaryWidget from '../components/CloudinaryWidget.vue';
import PetService from '../services/PetService';
export default {
  props: {
    photo: String,
    animalId: Number,
    animalName: String,
    animalType: String,
    gender: String,
    age: Number,
    description: String,
    breed: String,
    isAdoptable: Boolean,
  },
  data() {
    return {
      isModalVisible: false,
      isOnWalk: false,
      form: {
        animalId: this.animalId,
        photo: "", // Variable to store the image URL
      },
    };
  },
  components: {
    Modal,
    CloudinaryWidget,
  },
  methods: {
  handleToggleWalkAndModalVisibility() {
    this.toggleWalkStatus();
    this.showModal();
    this.triggerInit();
  },
  toggleWalkStatus() {
    this.isOnWalk = !this.isOnWalk;
  },
  showModal() {
    this.isModalVisible = true;
  },
  closeModal() {
    this.isModalVisible = false;
    this.isOnWalk = false;
  },
  triggerInit() {
      this.$root.$emit('Locations');
    },
  updatePhoto(imageUrl) {
      console.log(this.animalId);
      console.log('Update photo called'); // Add this line
      console.log('Updated form:', this.form);
      this.form.photo = imageUrl;
    
      PetService.updatePetPhoto(this.form)
       .then((response) => {
      if (response.status === 201) {
        console.log(response.status);
      }
    })
    .catch((error) => {
      console.error(error);
      // Handle error if form submission fails
    });
    },
  },
  watch: {
    isOnWalk(value) {
      if (value) {
        // Need to do an API update to make it show  when the pet start the walk
        console.log("The pet is on a walk!");
      } else {
        // Need to do an API update to make it show  when the pet ends the walk
        console.log("The pet has finished the walk.");
      }
    }
  },
  computed:{
    isLoggedIn() {
      return this.$store.state.token !== "";
    },
  },
    mounted() {
    console.log('Component mounted');
  },
};
</script>
<style>
</style>