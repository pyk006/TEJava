<template>
  <h1>Logout</h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    //Edited to homepage instead of logout
    this.$router.push("/");
  }
};
</script>
