import axios from 'axios';

export default {

    getPet() {
        return axios.get('/availablePets');
    },

    submitForm(formData) {
        return axios.post(`/availablePets/addPets`, formData)
    },

    editPet(animalObject) {
    return axios.put('/animals', animalObject)
    },
    
    updatePetPhoto(object) {
        return axios.put('/animals/updatePhoto', object)
    }
}