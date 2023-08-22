<template>
  <div id="app">
    <div id="nav">
      <img
        :src="require('@/assets/PRLogo.png')"
        alt="PR Logo"
        class="pr-logo"
      />
      <nav>
        <router-link class="button-link" v-bind:to="{ name: 'home' }">Home</router-link
        >&nbsp;
        <router-link class="button-link" v-bind:to="{ name: 'volunteer' }">Volunteer</router-link
        >&nbsp;
        <!-- <router-link class="button-link" v-bind:to="{ name: 'register' }">Register </router-link>
        &nbsp; -->
        <router-link class="button-link" v-bind:to="{ name: 'about-us' }">About Us </router-link>
        &nbsp;
        <template v-if="!isLoggedIn">
        <router-link class="button-link-last" v-bind:to="{ name: 'login' }">Login </router-link>
        </template>
        <template v-else>
        <router-link class="button-link-last"
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link>
          
          

        </template>  
      </nav>
    </div>
 
    <router-view />
 </div>
 
</template>

<script>
export default {
  computed: {
    isLoggedIn(){
      return this.$store.state.token !== '';
    },

  },
};

</script>
<style>
/* Global styles for scrollbar */

::-webkit-scrollbar {
  background-color: #b2d8f5;
}

::-webkit-scrollbar-track {
  background-clip: content-box;
}

::-webkit-scrollbar-thumb {
  height: 1px;
  border-radius: 100vw;
  border: 0.2em solid #b2d8f5;
  background-color: #ED815A;
}

</style>
<style scoped>
#app {
  font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  background-color: #b2d8f5;
  min-height: 100vh;
}

header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.pr-logo {
  display: flex;
  justify-items: start;
  align-items: center;
  width: 300px;
  margin-right: auto;
}

#nav {
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

.button-link, .button-link-last {
  font-weight: bold;
  text-decoration: none;
  background-color: #ED815A;
  padding: 4px 8px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.8); 
  color: rgb(5, 81, 119);
  cursor: pointer;
}

.button-link-last {
  margin-right: 10px;
}

.button-link:hover, .button-link-last:hover{
  background-color: #ED815A;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}


@media (max-width: 576px) {
  .pr-logo {
    width: 150px;
  }

 #nav {
    flex-direction: column;
    align-items: center;
  }

  .nav-links {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    width: 100%;
  }

  .button-link, .button-link-last {
    font-size: 12px;
    padding: 2px 6px;
    border-radius: 6px;
    margin-right: 5px;
    margin-bottom: 10px;
  }

}

</style>