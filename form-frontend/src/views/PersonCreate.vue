<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <div class="element-wrapper">
          <div class="element-box">
            <PersonEditForm
              :title="'Add new person'"
              :person="person"
              :submitTitle="'Create Person'"
              @submit="createPerson"
            ></PersonEditForm>
          </div>

          <div class="text-center">
            <router-link :to="{'name':'Home'}" class="text-danger">
              <i class="fa fa-times"></i> Cancel
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import person from "../services/person";
import PersonEditForm from "../components/PersonEditForm.vue";
export default {
  components: { PersonEditForm },
  data() {
    return {
      person: { name: null }
    };
  },
  mounted() {
    person.getAllList().then(r => (this.persons = r.data));
  },
  methods: {
    createPerson() {
      console.log("faef");
      person.createPerson(this.person).then(r => {
        alert("Succesfully created...");
        this.$router.push({ name: "Home" });
      });
    }
  }
};
</script>
