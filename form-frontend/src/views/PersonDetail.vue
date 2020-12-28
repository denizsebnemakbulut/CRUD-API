<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <div v-if="person" class="element-wrapper">
          <h4 class="element-header">
            {{ person.name }}
          </h4>

          <button @click="showEdit = !showEdit" class="btn btn-primary mb-3">
            <span v-if="showEdit">
              <i class="fa fa-minus"></i>
              Düzenlemeyi iptal et
            </span>
            <span v-else>
              <i class="fa fa-plus"></i>
              Kişiyi Düzenle
            </span>
          </button>

          <div v-if="showEdit" class="element-box">
            <PersonEditForm
              :title="'Kişiyi Düzenleyin'"
              :person="person"
              :submitTitle="'Kişiyi Güncelle'"
              @submit="updatePerson"
              :deleteTitle="'Kişiyi Sil'"
              @deletePerson="deletePerson"
            ></PersonEditForm>
          </div>

          <div>
            <Pagination :pagination="pagination" :displayPageSize="20" @pageChange="getPerson"></Pagination>

            <table v-if="pagination" class="table table-padded">
              <tbody>
                <tr v-for="a in pagination.result" :key="a.id">
                  <td>
                    {{a.timestamp|formatDate}} {{a.timestamp|formatTime }}
                    <br />
                    <small class="text-muted">{{a.timestamp|timeSince}}</small>
                  </td>
                </tr>
              </tbody>
            </table>

            <Pagination :pagination="pagination" :displayPageSize="20" @pageChange="getPerson"></Pagination>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import person from "../services/person";
import PersonEditForm from "../components/PersonEditForm";
import Pagination from "../components/Pagination"

export default {
  components: { PersonEditForm, Pagination},
data() {
    return {
      showEdit: false,
      person: null,
      pagination: null
    };
  },
  mounted() {
    
    person.getPersonDetail(this.$route.params.id).then(r => (this.person = r.data));
   
  },
  methods: {
    updatePerson(p) {
      person.updatePerson(p).then(r => {
        alert("Person updated");
        this.showEdit = false;
      });
    },
    deletePerson(p) {
      if (!confirm("Are you sure you want to delete this person?")) {
        return;
      }
      person.deletePerson(p.id).then(r => {
        alert("Person deleted.");
        this.$router.push({ name: "Home" });
      });
    },
    getPerson({ offset, page }) {
      personService
        .getPerson(this.$route.params.id, {
          ...Pagination.options,
          offset: offset
        })
        .then(r => {
          this.pagination = r.data;
        });
    },
  }
};
</script>
