<template>
  <div class="element-wrapper">
    <div class= "element-box">
    <h4 style= "margin-left:95px;">
      Person List
      <router-link :to="{ name: 'create_person' }" class="btn btn-primary float-right">
        <i class="fa fa-plus"></i>
        Create new person
      </router-link>
    </h4>

    <table class="table table-padded">
      <tbody>
        <tr v-for="p in persons" :key="p.id">
          <td class="bolder">
            {{ p.name }}
            <router-link :to="{ name: 'person_detail', params: { id: p.id } }"  class="btn btn-light.dropdown-toggle float-right">
            <i class="fa fa-pencil"></i>
            Düzenle
            </router-link>
          </td>
        </tr>
      </tbody>
    </table>
    </div>
  </div>
</template>

<script>
import person from "../services/person";

export default {
  data() {
    return {
      persons: []
    };
  },
  mounted() {
    person.getAllList().then(r => (this.persons = r.data));
  }
};
</script>
<style scoped>
.btn-primary,
.btn-primary:hover,
.btn-primary:focus{
    color: #fff;
    background-color: #8428c2;
    border-color: #8428c2;
    margin-top: 10px;
    margin-right: 10px;
}
.btn-primary:not(:disabled):not(.disabled):active,
.all-wrapper .fc-button.fc-state-active:not(:disabled):not(.disabled):active,
.btn-primary:not(:disabled):not(.disabled).active,
.all-wrapper .fc-button.fc-state-active:not(:disabled):not(.disabled).active,
.show>.btn-primary.dropdown-toggle,
.all-wrapper .show>.dropdown-toggle.fc-button.fc-state-active {
    color: #fff;
    background-color: #8428c2;
    border-color: #8428c2;
}
.btn-primary:not(:disabled):not(.disabled):active:focus,
.all-wrapper .fc-button.fc-state-active:not(:disabled):not(.disabled):active:focus,
.btn-primary:not(:disabled):not(.disabled).active:focus,
.all-wrapper .fc-button.fc-state-active:not(:disabled):not(.disabled).active:focus,
.show>.btn-primary.dropdown-toggle:focus,
.all-wrapper .show>.dropdown-toggle.fc-button.fc-state-active:focus {
    -webkit-box-shadow: 0 0 0 0.2rem #8428c2;
    box-shadow: 0 0 0 0.2rem #8428c2;
}
.btn-primary.disabled,
.all-wrapper .disabled.fc-button.fc-state-active,
.btn-primary:disabled,
.all-wrapper .fc-button.fc-state-active:disabled {
    color: #fff;
    background-color: #8428c2;
    border-color: #8428c2;
}
</style>


