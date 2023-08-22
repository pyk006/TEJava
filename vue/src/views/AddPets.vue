<template>
<div class ="page-wrap">

  <router-link class="availablepetslink" v-bind:to="{ name: 'availablePets' }">Go to Available Pets</router-link>


<div class="add-pet-form">
  <div class="form-container">
    <h2>Add Pet</h2>
      <CloudinaryComp ref="cloudinaryComp" @image-uploaded="handleImageUploaded" />

        <label for="animal-name">Name:</label>
        <input type="text" id="animal-name" v-model="form.animalName" required />

        <label for="animal-type">Type:</label>
        <input type="text" id="animal-type" v-model="form.animalType" required />

        <label for="gender">Gender:</label>
        <input type="text" id="gender" v-model="form.gender" required />

        <label for="description">Description:</label>
        <textarea id="description" v-model="form.description" maxlength="150" required ></textarea>

        <label for="breed">Breed:</label>
        <input type="text" id="breed" v-model="form.breed" required />

        <label for="age">Age:</label>
        <input type="text" id="Age" v-model="form.age" required />

          <label for="isAdoptable"> Adoptable:</label>
          <div class="radio-buttons">
            <label for="opt-in-yes">Yes</label>
            <input
              type="radio"
              id="opt-in-yes"
              value="true"
              v-model="form.adoptable"
          />
          <label for="isAdoptable">No</label>
            <input
              type="radio"
              id="opt-in-no"
              value="false"
              v-model="form.adoptable"
            />       
      </div>
      <br>
      <button type="submit" @click="submitForm">Submit</button>
    </div>
  </div>
</div>
</template>

<script>
import petService from '../services/PetService'
import CloudinaryComp from '../components/CloudinaryComp.vue'

export default {
  name: "addPets",
  components: {
    CloudinaryComp
  },
  data() {
    return {
      form: {
        animalName: "",
        animalType: "",
        gender: "",
        age: "",
        description: "",
        breed: "",
        isAdoptable: false,
        photo: "", 
      },
    };
  },


methods: {
 submitForm() {
  const cloudinaryComp = this.$refs.cloudinaryComp;
  if (cloudinaryComp.selectedFile) {
    cloudinaryComp.uploadImage().then((data) => {
      
      const imageUrl = data.url;


        this.handleImageUploaded(imageUrl);


        this.submitFormData();
     })
      .catch((error) => {
        console.error(error);

      });
  } else {
    console.log("Please select an image to upload");
  }
},
submitFormData() {

  petService.submitForm(this.form)
    .then((response) => {
      if (response.status === 201) {
        console.log(response.status);
        this.showForm = false; 
        window.alert("Form submitted successfully");
      }
    })
    .catch((error) => {
      console.error(error);
 
    });
},


  handleImageUploaded(imageUrl) {
  this.form.photo = imageUrl; 


  this.$emit("image-uploaded", imageUrl);
},

  },
};


</script>

<style>
.page-wrap {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.add-pet-form {
  border: 3px solid rgb(5, 81, 119);
  border-radius: 10px;
  width: 400px;
  height: 550px;
  padding: 0 10px;
  margin: 20px;
  background: rgb(5, 81, 119);
  color: rgb(160, 187, 226);
}
.form-container {
  display: flex;
  align-items: center;
  flex-direction: column;
  margin-right:20px;
  margin-top:20px;
}

.form-container label {
  margin: 2px 0;
}

.form-container input[type="text"] {
  padding: 5px;
  width: 200px;
}
.availablepetslink {
  display: flex;
  justify-content:center;
  font-weight: bold;
  text-decoration: none;
  background-color: #ED815A;
  padding: 4px 8px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.8); 
  color: rgb(5, 81, 119);
  cursor: pointer;
  width: fit-content;
  margin: 0 auto;
}

.availablepetslink:hover {
  background-color: #ED815A;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}

#opt-in-yes {
  margin-right: 15px;
}
#description {
  width: 210px;
}


</style>