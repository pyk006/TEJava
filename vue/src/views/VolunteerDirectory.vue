<template>
  <div class="directory-container">
    <div v-if="isLoggedIn" class="applications-link">
      <router-link class="application-button" v-bind:to="{ name: 'applications' }">Applications</router-link>
    </div>
    <h1 class="volunteer-directory">Volunteer Directory</h1>
    <div class="volunteer-card-container">
      <div
        class="volunteer-card"
        v-for="application in applications"
        :key="application.applicationId"
      >
        <img
          :src="getPhoto(application.photo)"
          alt="Profile Image"
          class="profile-image"
        />
        <br>
        <label v-if="isLoggedIn" for="image-upload">Update Photo:
          <CloudinaryWidget :photo="application.photo" @photo-uploaded="updatePhoto(application, $event)"  />
        </label>
        <div class="volunteer-card-content">
          <h3>{{ application.firstName }} {{ application.lastName }}</h3>
          <p>Phone Number: {{ application.phoneNumber }}</p>
          <p>Email: {{ application.email }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";
import CloudinaryWidget from "../components/CloudinaryWidget.vue";


export default {
  name: "VolunteerDirectory",
  props: {
    photo: String,
    applicationId: Number,
  },
  data() {
    return {
      applications: [],
      form: {
        applicationId: this.applicationId,
        photo: "", // Variable to store the image URL
      },  
    };
  },
  created() {
    this.fetchVolunteers();
  },
  components: {
    CloudinaryWidget,
  },
  methods: {
    fetchVolunteers() {
      volunteerService
        .getVolunteers()
        .then((response) => {
          this.applications = response.data;
        })
        .catch((error) => {
          console.error("Error fetching volunteers:", error);
        });
    },

    getPhoto(photo) {
      if (photo && photo.trim() !== "") {
        return photo;
      } else {
        return require("@/assets/blank-profile.png");
      }
    },
    updatePhoto(application, imageUrl) {
      console.log(application.applicationId);
      console.log('Update photo called'); // Add this line
      console.log('Updated form:', this.form);

      this.form = {
        applicationId: application.applicationId,
        photo: imageUrl
      };
    
      volunteerService.updateApplicationPhoto(this.form)
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
  
  computed: {
    isLoggedIn() {
      return this.$store.state.token !== "";
    },
  },
};
</script>

<style scoped>
.volunteer-directory {
  text-align: center;
  margin-bottom: 20px;
  color: rgb(5, 81, 119);
}

.volunteer-card-container {
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  color: whitesmoke;
}

.volunteer-card {
  border: 3px solid rgb(5, 81, 119);
  background-color: rgb(5, 81, 119);
  border-radius: 10px;
  width: 300px;
  height: 300px;
  padding: 0 20px;
  margin: 10px;
}

.profile-image {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 50%;
  margin-top: 10px;
  margin-bottom: 10px;
}

.application-button {
  display: inline-block;
  text-decoration: none;
  margin-top: 10px;
  margin-left: 10px;
  font-weight: bold;
  padding: 4px 8px;
  background-color: #ed815a;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: rgb(5, 81, 119);
}

.application-button:hover {
  background-color: #ed815a;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}

@media (max-width: 576px) {
  .directory-container {
    margin: 0 20px; /* Adjust the margin as desired */
  }

  .volunteer-card {
    width: 100%; /* Make the cards take full width */
  }
}
</style>