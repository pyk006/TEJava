import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import AboutUs from '../views/AboutUs.vue'
import store from '../store/index'
import Volunteer from '../views/Volunteer.vue'
import AvailablePets from '../views/AvailablePets.vue'
import Applications from '../views/Applications.vue'
import AddPets from '../views/AddPets.vue'
import EditPets from '../views/EditPets.vue'
import VolunteerDirectory from '../views/VolunteerDirectory.vue'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/about-us",
      name: "about-us",
      component: AboutUs,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/volunteer",
      name: "volunteer",
      component: Volunteer,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/volunteer/submit-form",
      name: "submit-form",
      component: Volunteer
    },
    {
      path: "/availablePets",
      name: "availablePets",
      component: AvailablePets
    },
    {
      path: "/availablePets/addPets",
      name: "addPets",
      component: AddPets,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/availablePets/editPets",
      name: "editPets",
      component: EditPets,
      meta: {
        requiresAuth: true
      },
      props: true,
    },
    {
      path: "/volunteer/applications",
      name: "applications",
      component: Applications,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/directory",
      name: "volunteer-directory",
      component: VolunteerDirectory,
      meta: {
        requiresAuth: false
      }
    },
    
  ]
})

router.beforeEach((to, from, next) => {

  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);


  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
 
    next();
  }
});

export default router;
