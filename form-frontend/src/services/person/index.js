import axios from "axios";
export default {
    getAllList() {
        return axios.get("http://localhost:8080/person");
    },
    createPerson(person) {
        return axios.post(`http://localhost:8080/person`, person);
    },
    updatePerson(person) {
        return axios.put(`http://localhost:8080/person`, person);
    },
    deletePerson(personId) {
        return axios.delete(`http://localhost:8080/person/${personId}`);
    },
    getPersonDetail(personId) {
        return axios.get(`http://localhost:8080/person/${personId}`);
    }
};