<template>
  <div>
    <button v-on:click="upload">Upload</button><br>
  </div>
</template>
<script>
export default {
  name: 'CloudinaryWidget',
  data() {
    return {
      myWidget: {}
    }
  },
  methods: {
    upload() {
      this.myWidget.open({
        cloudName: 'dydfdj1r5',
        uploadPreset: 'un133o5a'
      });
    },
    handleFileUploadDone(result) {
      if (result.event === 'success' && result.info && result.info.url) {
        const imageUrl = result.info.url;
        console.log('Photo uploaded:', imageUrl);
        this.$emit('photo-uploaded', imageUrl);
      }
    }
  },
  mounted() {
    this.myWidget = window.cloudinary.createUploadWidget(
      {
        cloudName: 'dydfdj1r5',
        uploadPreset: 'un133o5a'
      },
      (error, result) => {
        if (!error && result && result.event === 'success') {
          console.log('Done! Here is the image info:', result.info);
          console.log('Image URL:', result.info.url);
          this.handleFileUploadDone(result);
        }
      }
    );
  }
}
</script>
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42B983;
}
</style>