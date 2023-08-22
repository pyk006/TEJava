<template>
  <div>
    
    <h1>Applications</h1>

    <div class="search-container">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Search by name"
        @keyup.enter="searchApplications"
      />
      <button @click="searchApplications">Search</button>
    </div>
    <div class="directory-link">
      <template v-if="isLoggedIn">
        <router-link
          class="volunteer-directory-link"
          v-bind:to="{ path: '/directory' }"
          >Volunteer Directory</router-link
        >
      </template>
    </div>
    <table id="tblApplications">
      <thead>
        <tr>
          <th>Admin Approval</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Date of Birth</th>
          <th>Address</th>
          <th>School Mascot</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th>Opt-in Text</th>
          <th>Prior Experience</th>
          <th>Transportation</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="application in filteredApplications"
          :key="application.applicationId"
        >
          <td>
            <select
              v-model="application.adminApproval"
              @change="updateAdminApproval(application)"
            >
              <option value="Pending">Pending</option>
              <option value="Approved">Approve</option>
              <option value="Declined">Decline</option>
            </select>
          </td>
          <td>{{ application.firstName }}</td>
          <td>{{ application.lastName }}</td>
          <td>{{ application.dateOfBirth }}</td>
          <td>{{ application.homeAddress }}</td>
          <td>{{ application.schoolMascot }}</td>
          <td>{{ application.email }}</td>
          <td>{{ application.phoneNumber }}</td>
          <td>{{ application.optInText }}</td>
          <td>{{ application.experience }}</td>
          <td>{{ application.transportation }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import volunteerService from "../services/VolunteerService";
import authService from "../services/AuthService";

export default {
  name: "applications-list",
  data() {
    return {
      applications: [],
      filteredApplications: [],
      searchQuery: "",
    };
  },
  created() {
    this.fetchApplications();
  },

  methods: {
    fetchApplications() {
      volunteerService
        .getApplications()
        .then((response) => {
          this.applications = response.data;
          this.filteredApplications = response.data;
          console.log(response.data);
        })
        .catch((error) => {
          console.error("Error fetching applications:", error);
        });
    },
    updateAdminApproval(application) {
      const newStatus =
        application.adminApproval === "Approved" ? "Approved" : "Declined";
      const isNewlyApproved = newStatus === "Approved";
      volunteerService
        .updateApplication({
          adminApproval: newStatus,
          applicationId: application.applicationId,
        })
        .then((response) => {
          console.log("Admin approval updated successfully:", response.data);
          const updatedApplicationIndex = this.applications.findIndex(
            (app) => app.applicationId === application.applicationId
          );
          if (updatedApplicationIndex !== -1) {
            // Update the admin approval status
            this.applications[updatedApplicationIndex].adminApproval =
              newStatus;
          }
          if (!isNewlyApproved) {
            // Remove the application from the list view
            this.applications.splice(updatedApplicationIndex, 1);
          }
          if (isNewlyApproved) {
            // Register the user as a new user with an auto-generated password
            const newUser = {
              username: application.email,
              password: "tepawsvolunteer",
              confirmPassword: "tepawsvolunteer",
              role: "user",
            };
            authService
              .register(newUser)
              .then((registerResponse) => {
                if (registerResponse.status === 201) {
                  console.log(
                    "User registered successfully:",
                    registerResponse.data
                  );
                  // push new user to the database..
                  window.alert("New user added successfully");
                }
              })
              .catch((registerError) => {
                console.error("Error registering user:", registerError);
              });
          }
        })
        .catch((error) => {
          console.error("Error updating admin approval:", error);
        });
    },
    searchApplications() {
      if (this.searchQuery) {
        const query = this.searchQuery.toLowerCase();
        this.filteredApplications = this.applications.filter(
          (application) =>
            application.firstName.toLowerCase().includes(query) ||
            application.lastName.toLowerCase().includes(query)
        );
      } else {
        this.filteredApplications = this.applications; // Reset filteredApplications to original data
      }
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
h1 {
  color: rgb(5, 81, 119);
  text-align: center;
}
.container {
  max-width: 100vw;
  margin: 0 auto;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  margin-bottom: 20px;
}

th,
td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

th {
  background-color: #f2f2f2;
  font-weight: bold;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

tr:hover {
  background-color: #ddd;
}

.volunteer-directory-link {
  display: flex;
  justify-content:center;
  margin-top: 10px;
  margin-left: 10px;
  font-weight: bold;
  padding: 4px 8px;
  background-color: #ed815a;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.8);
  color: rgb(5, 81, 119);
  text-decoration: none;
  width: fit-content;
  margin: 0 auto;
}

.volunteer-directory-link:hover {
  background-color: #ed815a;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}

@media (max-width: 600px) {
  /* Mobile styles */
  .table-container {
    display: flex;
    flex-direction: column;
    align-items: stretch;
    overflow-x: auto;
  }

  table {
    font-size: 12px;
  }

  th,
  td {
    padding: 6px;
  }

  .volunteer-directory-link {
    font-size: 14px;
  }
}

</style>