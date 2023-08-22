<template>
  <div class="volunteer">
      <div v-if="isLoggedIn" class="applications-link">
        <router-link
          class="application-button"
          v-bind:to="{ name: 'applications' }"
          >Applications</router-link
        >
      </div>
    <h2>Volunteer With Us</h2>
    <p>
      At TE Paw Rescue, we are always looking for dedicated and compassionate
      individuals who share our love for animals. As a volunteer, you'll have
      the opportunity to make a meaningful impact on the lives of the animals in
      our care, and contribute to their well-being and eventual adoption into
      loving homes.
    </p>
    <h3>Qualifications:</h3>
    <ul>
      <li>Age: Volunteers must be 18 years or older.</li>
      <li>Animal Experience: Prior experience is valued but not mandatory.</li>
      <li>Availability: Commitment of a minimum of 15 hours per week.</li>
      <li>
        Non-Paid Position: This is a volunteer position without monetary
        compensation.
      </li>
      <li>Physical Requirements: Capable of lifting at least 25 pounds.</li>
    </ul>

    <h3>Responsibilities and Opportunities:</h3>
    <ul>
      <li>Animal Care: Feeding, grooming, and exercising animals.</li>
      <li>Socialization: Providing love, attention, and social interaction.</li>
      <li>
        Adoption Support: Assisting potential adopters and conducting
        meet-and-greet sessions.
      </li>
      <li>
        Facility Maintenance: Cleaning animal enclosures and ensuring a tidy
        environment.
      </li>
      <li>
        Special Events: Participating in fundraising and community outreach
        programs.
      </li>
    </ul>
    <p>
      By joining our volunteer team, you'll contribute to the well-being of our
      animals and become part of a supportive community. Apply now to create a
      brighter future for these deserving animals!
    </p>

    <button @click="toggleForm" v-if="!showForm">
      Apply to be a Volunteer Here
    </button>

    <div v-if="showForm" class="form-container">
      <form class="form" @submit.prevent="submitForm">
        <label for="first-name">First Name:</label>
        <input type="text" id="first-name" v-model="form.firstName" required />

        <label for="last-name">Last Name:</label>
        <input type="text" id="last-name" v-model="form.lastName" required />

        <label for="dob">Date of Birth (YYYY-MM-DD):</label>
        <input type="date" id="dob" v-model="form.dateOfBirth" required />

        <label for="">Location(for on call):</label>
        <input
          type="homeAddress"
          id="homeAddress"
          v-model="form.homeAddress"
          required
        />

        <label for="">Availability (hours per week):</label>
        <input
          type="availability"
          id="availabilities"
          v-model="form.availability"
          required
        />

        <label for="school-mascot">School Mascot:</label>
        <input type="text" id="school-mascot" v-model="form.schoolMascot" />

        <label for="email">Email:</label>
        <input type="email" id="email" v-model="form.email" required />

        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" v-model="form.phoneNumber" required />

  
        <div>
          <label for="opt-in">Opt-in for Text Messages:</label>
          <div class="radio-buttons">
            <label for="opt-in-yes">Yes</label>
            <input
              type="radio"
              id="opt-in-yes"
              value="true"
              v-model="form.optInText"
            />

            <label for="opt-in-no">No</label>
            <input
              type="radio"
              id="opt-in-no"
              value="false"
              v-model="form.optInText"
            />
          </div>
        </div>

        <div>
          <label for="opt-in">Would you submit a background check:</label>
          <div class="radio-buttons">
            <label for="background-check-yes">Yes</label>
            <input
              type="radio"
              id="background-check-yes"
              value="true"
              v-model="form.bkgrndCheckApproved"
            />

            <label for="background-check-no">No</label>
            <input
              type="radio"
              id="background-check-no"
              value="false"
              v-model="form.bkgrndCheckApproved"
            />
          </div>
        </div>

        <div>
          <label for="opt-in"
            >Do you have any experience working with animals at a shelter or vet
            clinic:</label
          >
          <div class="radio-buttons">
            <label for="experience-yes">Yes</label>
            <input
              type="radio"
              id="experience-yes"
              value="true"
              v-model="form.experience"
            />

            <label for="experience-no">No</label>
            <input
              type="radio"
              id="experience-no"
              value="false"
              v-model="form.experience"
            />
          </div>
        </div>

        <div>
          <label for="opt-in">Do you have a means of transportation:</label>
          <div class="radio-buttons">
            <label for="transportation-yes">Yes</label>
            <input
              type="radio"
              id="transportation-yes"
              value="true"
              v-model="form.transportation"
            />

            <label for="transportation-no">No</label>
            <input
              type="radio"
              id="transportation-no"
              value="false"
              v-model="form.transportation"
            />
          </div>
        </div>
        <button type="submit">Submit</button>
        <button type="reset" @click="toggleForm">Close</button>
      </form>
    </div>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";

export default {
  name: "volunteer",
  data() {
    return {
      showForm: false,
      form: {
        firstName: "",
        lastName: "",
        dateOfBirth: "",
        homeAddress: "",
        availability: "",
        schoolMascot: "",
        email: "",
        phoneNumber: "",
        optInText: false,
        experience: false,
        transportation: false,
        bkgrndCheckApproved: false,
      },
    };
  },
  methods: {
    toggleForm() {
      this.resetForm();
      this.showForm = !this.showForm;
    },
    resetForm() {
      // Reset form fields to initial values
      this.form = {
        firstName: "",
        lastName: "",
        dateOfBirth: "",
        homeAddress: "",
        availability: "",
        schoolMascot: "",
        email: "",
        phoneNumber: "",
        optInText: false,
        experience: false,
        transportation: false,
        bkgrndCheckApproved: false,
      };
    },
    submitForm() {
      volunteerService.submitForm(this.form).then((response) => {
        if (response.status === 201) {
          console.log(response.status);
          this.form.dateOfBirth = this.form.dateOfBirth.toString();
          this.showForm = false; //hide after successful submission
          this.$router.push({ name: "volunteer" });
        }
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
.volunteer {
  color: rgb(5, 81, 119); ;
}

.form-container {
  margin-top: 20px;
  border: 5px solid #366a8c;
}
form {
  margin-left: 20px;
  margin-bottom: 20px;
  margin-top: 10px;
}
label {
  display: block;
  margin-bottom: 5px;
}
.opt-in-container {
  display: inline-block;
}
.opt-in-container input[type="radio"] {
  margin-right: 5px;
}

button[type="submit"] {
  margin-top: 10px;
  margin-right: 10px;
}

.radio-buttons {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.radio-buttons label {
  margin-left: 10px;
  margin-right: 5px;
}

.radio-buttons input[type="radio"] {
  margin-right: 5px;
}

.application-button {
  display: inline-block;
  font-weight: bold;
  text-decoration: none;
  background-color: #ed815a;
  padding: 4px 8px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: rgb(5, 81, 119);
  cursor: pointer;
  margin-left: 10px;
}

.application-button:hover {
  background-color: #ed815a;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}

</style>


