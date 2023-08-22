<template>
  <div class="home">
    <div class="homepage-links-container">
      <router-link class="homepage-link" v-bind:to="{ name: 'availablePets' }"
        >Available Pets</router-link
      >
    </div>

    <div class="banner">
      <div class="banner-slider">
        <div
          class="banner-slide"
          v-for="(slide, index) in bannerSlides"
          :key="index"
        >
          <img :src="slide" alt="Banner Slide" class="slide-image" />
        </div>
      </div>
    </div>

    <div class="main-content">
      <div id="who-we-are">WHO WE ARE</div>
      <p id="who">
        TE Paws Rescue, located in the heart of Portland, OR, is a renowned
        animal shelter specializing in dogs while embracing all creatures in
        need. With a capacity for 113 animals, we provide a safe haven for cats,
        bunnies, lizards, and even the occasional goat. Our dedication to
        inclusivity ensures that no animal is turned away.
        <br /><br />
        At TE Paws Rescue, visitors are welcome to witness the compassionate
        care firsthand. While you explore the shelter, you might encounter
        joyful dogs seeking human connection. However, please note that some
        dogs may be out on walks. To plan your visit accordingly, check their
        info page for updates on availability.
        <br /><br />
        TE Paws Rescue thrives on the belief that every animal deserves love and
        a forever home. By opening our doors to a diverse range of species, we
        offer a unique opportunity for animal enthusiasts and potential adopters
        alike to experience the heartwarming connections that can be forged at
        our shelter.
      </p>
      <div id="our-goals">OUR GOALS</div>
      <p id="goals">
        At TE Paws Rescue, our primary goal is to provide a safe haven for
        animals in need and ensure their well-being. We are committed to finding
        loving homes for our residents. By offering a diverse range of animals
        for adoption, TE Paws Rescue aims to match each animal with a caring and
        responsible owner, creating lasting bonds that bring joy to both humans
        and animals.
        <br /><br />
        In addition to our adoption efforts, TE Paws Rescue strives to educate
        the community about responsible pet ownership, animal welfare, and the
        importance of spaying/neutering. We believe that by spreading awareness
        and knowledge, we can make a positive impact and reduce the number of
        animals in need of rescue. Through our outreach programs, events, and
        partnerships, TE Paws Rescue endeavors to create a compassionate
        community that values and advocates for the well-being of all animals.
      </p>

      <div id="how-to-help">HOW TO HELP</div>
      <p id="help">
        Volunteers and the community play a vital role in supporting TE Paws
        Rescue's mission. By donating your time and skills, volunteers can
        assist with daily care, socialization, and administrative tasks,
        creating a nurturing environment for our animals.
        <br /><br />
        Sharing our shelter's message, organizing fundraising events, and
        hosting adoption drives in the community are effective ways for
        individuals to help us find loving homes for our residents. Financial
        contributions also make a significant impact by providing medical care,
        nutrition, and comfortable accommodations. Together, with the support of
        volunteers and the community, we can make a positive difference in the
        lives of animals in need at TE Paws Rescue.
      </p>
    </div>

    <footer>
      <div id="contact-us">Contact Us:</div>
      <div class="contact-info">
        <div class="contact-item">
          <img src="@/assets/phone.png" alt="Phone Icon" class="icon" />
          <span>555-555-5555</span>
        </div>
        <div class="contact-item">
          <img src="@/assets/mail.png" alt="Email Icon" class="icon" />
          <span>tepawsrescue@gmail.com</span>
        </div>
      </div>
      <div id="find-us">Find Us:</div>
      <div class="address">
        <img src="@/assets/location-pin.png" alt="Location Icon" class="icon" />
        <span>6305 SE Foster Rd, Portland, OR 97206</span>
      </div>
      <div id="follow-us">Follow Us:</div>
      <div class="social-icons">
        <a href="https://www.facebook.com/profile.php?id=100093189323422" target="_blank">
      <img src="@/assets/facebook.png" alt="Facebook Icon" class="icon" />
    </a>
    <a href="https://www.instagram.com/tepawsrescue/" target="_blank">
      <img src="@/assets/instagram.png" alt="Instagram Icon" class="icon" />
    </a>
      </div>
    
    </footer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      bannerSlides: [
        require("@/assets/adoptedPics/kobe.png"),
        require("@/assets/adoptedPics/jaeger.png"),
        require("@/assets/adoptedPics/kiaser.png"),
        require("@/assets/adoptedPics/noodles.png"),
        require("@/assets/adoptedPics/ponyo.png"),
        require("@/assets/adoptedPics/velvet.png"),
        require("@/assets/adoptedPics/sammy.png"),
        require("@/assets/adoptedPics/siren.png"),
      ],
    };
  },
  mounted() {
    this.startBannerAnimation();
  },
  methods: {
    startBannerAnimation() {
      const bannerSlider = document.querySelector(".banner-slider");

      setInterval(() => {
        const firstSlide = bannerSlider.querySelector(".banner-slide");
        bannerSlider.appendChild(firstSlide);
      }, 3000);
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

.banner {
  overflow: hidden;
  white-space: nowrap;
  max-width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.banner-slider {
  display: inline-block;
  animation: rollBannerAnimation linear infinite;
  animation-duration: 12s;
  border: 3px solid rgb(5, 81, 119);
  border-left: none;
  border-right: none;
  padding: 3px 0;
  box-sizing: border-box;
  transition: transform 0.5s cubic-bezier(0.645, 0.045, 0.355, 1);
}

.banner-slide {
  display: inline-block;
  animation: bannerAnimation linear infinite;
  animation-duration: 12s;
  transition: transform 0.5s ease-in-out;
}

.slide-image {
  width: 300px;
  height: 350px;
  object-fit: cover;
}

#who {
  grid-area: who;
}

#help {
  grid-area: help;
}

#goals {
  grid-area: goals;
}

#who-we-are,
#our-goals,
#how-to-help {
  font-weight: bold;
  color: whitesmoke;
  font-size: 40px;
}

.main-content {
  display: grid;
  align-content: center;
  justify-items: center;
  grid-template-columns: repeat(3, 1fr);
  grid-template-areas:
    "who-we-are our-goals how-to-help"
    "who goals help";
  grid-gap: 20px;
  background-color: #6fb3d1;
  color: whitesmoke;
  padding: 20px;
  font-size: 20px;
}

footer {
  background-color: #366a8c;
  padding: 20px;
  display: grid;
  align-content: flex-start;
  grid-template-columns: repeat(3, 1fr);
  grid-template-areas:
    "contact-us find-us follow-us"
    "contact-info address social-icons"
    "contact-info address social-icons";
  color: whitesmoke;
}

#contact-us {
  grid-area: contact-us;
}

.contact-info {
  grid-area: contact-info;
}

#find-us {
  grid-area: find-us;
}

.address {
  grid-area: address;
  display: flex;
  justify-content: flex-start;
}

#follow-us {
  grid-area: follow-us;
}

.contact-info {
  display: flex;
  flex-direction: column;
}

.contact-item {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.icon {
  width: 20px;
  height: 20px;
  margin-right: 10px;
}

.address {
  margin-top: 10px;
  text-align: center;
}

.social-icons {
  display: flex;
  justify-content: flex-start;
  margin-top: 10px;
  grid-area: social-icons;
}

.social-icons .icon {
  width: 30px;
  height: 30px;
  margin-right: 10px;
}

.homepage-links-container {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.homepage-link {
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
.homepage-link:hover {
  background-color: #ed815a;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.8);
}

@media (max-width: 576px) {
  .main-content {
    grid-template-columns: 1fr;
    grid-template-areas:
      "who-we-are"
      "who"
      "our-goals"
      "goals"
      "how-to-help"
      "help";
  }

  .main-content > * {
    margin-bottom: 20px;
  }

  footer {
    grid-template-columns: 1fr;
    grid-template-areas:
      "contact-us"
      "contact-info"
      "find-us"
      "address"
      "follow-us"
      "social-icons";
  }

  .address {
    text-align: left;
  }

  .banner-slider {
    padding: 1px 0;
    border-width: 2px;
  }

  .banner-slide {
    margin-bottom: 5px;
  }

  .slide-image {
    width: 140px;
    height: 140px;
  }

  .homepage-links-container {
    flex-direction: column;
    align-items: center;
    margin-bottom: 20px;
  }

  .homepage-link {
    margin-bottom: 10px;
    font-size: 14px;
  }

    .applications-link {
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
  }

  .application-button {
    font-weight: bold;
    text-decoration: none;
    background-color: #ED815A;
    padding: 4px 8px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.8); 
    color: rgb(5, 81, 119);
    cursor: pointer;
    max-width: 200px; 
  }
}
</style>