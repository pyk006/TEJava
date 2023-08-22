<template>
  <div class="new-pets">
    
    
    <div class="available-container">
      <h1 class="availablepets">Available Pets</h1>
      <div class="search-container">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search by animal type"
      />
      <button @click="searchPets">Search</button>
    </div>

      <router-link
      class="add-pet" 
      v-if="isLoggedIn"
      v-bind:to="{ name: 'addPets' }"
      >Add Pet</router-link>
      <div class="pet-card-container">
        <div class="pet-cards" v-for="pet in filteredPets" :key="pet.animal_id">
          <pet
            :photo="pet.photo"
            :animalId = "pet.animalId"
            :animalName="pet.animalName"
            :animalType="pet.animalType"
            :gender="pet.gender"
            :age="pet.age"
            :description="pet.description"
            :breed="pet.breed"
            :isAdoptable="pet.adoptable"
          />
<router-link
      class="button-edit-pets"
      v-if="isLoggedIn"
      v-bind:to="{ name: 'editPets', params: {pet: pet} }"
      >Edit</router-link
    >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Pet from "@/components/PetCard.vue";
import petService from "../services/PetService";

export default {
  components: {
    Pet,
  },
  data() {
    return {
      pets: [],
      searchQuery: "",
    };
  },
  created() {
    this.fetchPets();
  },
  methods: {
    fetchPets() {
      petService
        .getPet(this.searchQuery)
        .then((response) => {
          this.pets = response.data;
          console.log(response.data);
          console.log(response.data[0].adoptable);
        })
        .catch((error) => {
          console.error("Error loading pets.", error);
        });
    },
    searchPets() {
      this.fetchPets();
    },
    updateSearchQuery(event) {
      this.searchQuery = event.target.value;
    },
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token !== "";
    },
    filteredPets() {
      if (this.searchQuery) {
        return this.pets.filter((pet) => {
          return pet.animalType.toLowerCase().includes(this.searchQuery.toLowerCase()) && pet.isAdoptable
        }
        );
      } else {
        return this.pets.filter((pet) => pet.isAdoptable);

      }
    },
  },
};
</script>

<style>
.availablepets {
  text-align: center;
  margin-bottom: 20px;
  color: rgb(5, 81, 119);
}

.pet-card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: flex-start;
  color: white;
}

.pet-cards {
  border: 3px solid rgb(5, 81, 119);
  border-radius: 10px;
  max-width: 400px;
  height: 850px;
  padding: 0 10px;
  margin: 10px;
  background: rgb(5, 81, 119);;
}

.pet-cards .pet-photo {
  width: 100%;
  height: 300px; 
  object-fit: cover;
  border-radius: 10px;
  margin-top: 5px;
}

.pet-cards .pet-info {
  padding: 0px;
}

.search-container {
  margin-bottom: 15px;
  margin-left: 20px;
  display: flex;
  justify-content:center;
  height: 30px;
}

.search-container input {
  width: 200px;
  padding: 10px;
  margin-right: 20px;
  
}

.search-container button {
  display: inline-block;
  font-weight: bold;
  font-size: 14px;
  text-decoration: none;
  background-color: #ed815a;
  padding: 4px 8px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: rgb(5, 81, 119);
  cursor: pointer;
  margin-left: 10px;
  }

/* .search-container button {
  background-color: rgb(5, 81, 119);
  color: white;
  padding: 5px 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
} */



.add-pet {
  display: flex;
  justify-content:center;
  font-weight: bold;
  text-decoration: none;
  background-color: #ed815a;
  padding: 4px 8px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: rgb(5, 81, 119);
  cursor: pointer;
  width: fit-content;
  margin: 0 auto;
  margin-bottom: 10px;
}

.add-pet:hover{
   background-color: #ED815A;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}

/* .button-link-last:hover {
  opacity: 0.8;
} */
.button-edit-pets{
  display: flex;
  justify-content: center;
  font-weight: bold;
  text-decoration: none;
  background-color: #ed815a;
  padding: 4px 8px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: rgb(5, 81, 119);
  cursor: pointer;
  margin-top: 10px;
}

@media (max-width: 768px) {
  .pet-card-container {
    justify-content: center; 
  }

  .pet-cards {
    width: 100%; 
    max-width: none; 
    margin: 10px 0; 
  }
}

</style>
