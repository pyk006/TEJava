<template>
  
  <div>  
    <div id="grid-container">

      <!--Google Maps will render map here-->
      <div id="map"></div>


      <div id="input-area">


          Location to Add: <input v-model="currentInput" type="input"/>
          <button class = "route-btn" v-on:click="addToList">Add to Route</button>
          
          <p>Current Locations:</p>
          <button class = "route-btn" v-on:click="generateRoute">Generate Route</button><br><br>
          <div id="currentList" v-for="(location, index) of locations" v-bind:key="index">
              <input class="current-inputs" v-model="locations[index]"/> <button class = "route-btn" v-on:click="removeFromList(index)">Remove</button>
          </div>
      </div>

      <!--Google Maps will render directions here-->
      <div id="panel"></div>

    </div>
  </div>
</template>

<script>
export default {
  name: "Map",
  data() {
    return {
      map: null,
      routeService : null,
      routeRendererService: null,
      currentInput : "",
      roundTrip : true,
      mapCenter: { lat: 45.490509, lng: -122.598167 },
      locations: [],
    };
  },

  
  methods: {
    calculateRandomLocation() {
  // Convert the latitude and longitude to radians
  const radiansLat = this.mapCenter.lat * (Math.PI / 180);
  const radiansLong = this.mapCenter.lng * (Math.PI / 180);

  // Earth's radius in miles
  const earthRadiusMiles = 3959;
  const minDistanceInMiles = 1;
  const maxDistanceInMiles = 3;
  // Convert the minimum and maximum distances to radians
  const minDistanceRadians = minDistanceInMiles / earthRadiusMiles;
  const maxDistanceRadians = maxDistanceInMiles / earthRadiusMiles;

  // Calculate a random distance between the minimum and maximum distances
  const distanceRadians = Math.random() * (maxDistanceRadians - minDistanceRadians) + minDistanceRadians;

  // Calculate a random angle in radians
  const angle = Math.random() * 2 * Math.PI;

  // Calculate the new latitude and longitude
  const newLatitude = Math.asin(Math.sin(radiansLat) * Math.cos(distanceRadians) +
                    Math.cos(radiansLat) * Math.sin(distanceRadians) * Math.cos(angle));

  const newLongitude = radiansLong + Math.atan2(Math.sin(angle) * Math.sin(distanceRadians) * Math.cos(radiansLong),
                        Math.cos(distanceRadians) - Math.sin(radiansLong) * Math.sin(newLatitude));

  // Convert the new latitude and longitude back to degrees
  const newLatitudeDegrees = newLatitude * (180 / Math.PI);
  const newLongitudeDegrees = newLongitude * (180 / Math.PI);

  return [newLatitudeDegrees, newLongitudeDegrees];
},
    // This function is called during load, but can also be called to reset the map
    initMap() {
      this.map = new window.google.maps.Map(document.getElementById("map"), {
        center: this.mapCenter,
        zoom: 14,
        maxZoom: 20,
        minZoom: 3,
        streetViewControl: true,
        mapTypeControl: true,
        fullscreenControl: true,
        zoomControl: true,
      });
      let noPOIStyle = [
        {
          featureType: "poi",
          elementType: "labels",
          stylers: [{ visibility: "off" }],
        },
      ];
      this.map.setOptions({ styles: noPOIStyle });
    },

    // This function is called to add a new location
    addToList() {

        if(this.currentInput.trim().length === 0) {
            window.alert("Location cannot be empty");
            return;
        }
        this.locations.push(this.currentInput);
        this.currentInput = "";
    },

    // This function is called to remove a location
    removeFromList(index) {

        if(this.locations.length == 2) {
          window.alert("A start and end location must be present");
          return;
        }

        this.locations.splice(index, 1);
    },

    // This function calls the Google Maps API, renders the route
    // and retrieves the directions
    generateRoute() {

      for(let i=0; i < this.locations.length; i++) {

        if (this.locations[i].trim().length === 0) {
          window.alert("Location cannot be empty");
          return;
        }
      }


      const panel = document.getElementById("panel");
      panel.innerHTML = '';
      this.initMap();

       this.routeService = new window.google.maps.DirectionsService();
       this.routeRendererService = new window.google.maps.DirectionsRenderer();
       
       this.routeRendererService.setMap(this.map);
       this.routeRendererService.setPanel(panel);

      let myWaypoints = [];
      
      
      /*
        The API expects a single waypoint to be an object like this:
        
        {
          location: "123 somewhere St...",
          stopover: true
        }
      */

      for(let i=1; i < this.locations.length -1; i++) {
        myWaypoints.push( 
          {
            location: this.locations[i],
            stopover: true
          }
        );
      }

       this.routeService.route(
        {
          origin: this.locations[0],
          destination: this.locations[this.locations.length-1],
          waypoints: myWaypoints,
          travelMode: window.google.maps.TravelMode.WALKING,
          avoidTolls: true,
          optimizeWaypoints: true
        }
       ).then(
          (result) => {
            this.routeRendererService.setDirections(result);
          }
       ). catch(
          (error) => {
            console.log(error + "Could not generate route");
          }
       );

    }
  },
  

  mounted() {
    this.locations.push(this.calculateRandomLocation().toString());
    this.locations.push("45.490509, -122.598167");
    this.locations.push(this.calculateRandomLocation().toString());
    this.initMap();

  },
};
</script>

<style>

#grid-container {
  display: grid;
  background-color: #b2d8f5;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "map inputs"
  "directions directions";
}

#map {
  grid-area: map;
  width: 450px;
  height: 200px;
  padding: 25px;
  margin: 25px;
}

#input-area {
  grid-area: inputs;

}

#panel {
  grid-area: directions;
  height: 200px;
  overflow-y:auto;
}

.current-inputs {
  width: 350px;
}

.route-btn {
    background-color: #ED815A;
    color: #0870a3;
    font-weight: bold;
    border-radius: 8px;
}
.route-btn:hover {
  cursor:pointer;
}
</style>