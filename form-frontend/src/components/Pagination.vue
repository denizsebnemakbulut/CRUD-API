<template>
  <div>
    <nav v-if="displayPages.length>1">
      <ul class="pagination">
        <li @click="getPrev" class="page-item">
          <a class="page-link" href="javascript:;">
            <i class="fa fa-chevron-left"></i>
          </a>
        </li>
        <li
          v-for="i in displayPages"
          @click="getPage(i)"
          :class="{'active':i==currentPage}"
          class="page-item"
          :key="'page_number'+i"
        >
          <a class="page-link" href="javascript:;">{{i}}</a>
        </li>
        <li @click="getNext" v-if="pagination.hasNext" class="page-item">
          <a class="page-link" href="javascript:;">
            <i class="fa fa-chevron-right"></i>
          </a>
        </li>
      </ul>
    </nav>
  </div>
</template>
<script>
export default {
  props: ["pagination", "displayPageSize"],
  options: {
    order: "desc",
    orderField: "_id",
    limit: 10,
    offset: 0
  },
  data() {
    return {
      totalPage: 1,
      currentPage: 1,
      displayPages: []
    };
  },
  mounted() {},
  watch: {
    pagination: {
      handler: function(current, prev) {
        this.totalPage = this.pagination.count;
        this.currentPage = this.pagination.current;
        this.calculatePageRangeView();
      },
      deep: true
    }
  },
  methods: {
    emit() {
      var offset = this.pagination.limit * (this.currentPage - 1);
      offset = offset < 1 ? 1 : offset;
      this.$emit("pageChange", {
        offset: offset,
        page: this.currentPage
      });
    },
    getPage(page) {
      if (page) {
        this.currentPage = page;
      }
      if (this.currentPage <= 0) {
        this.currentPage = 1;
      } else if (this.totalPage > 0 && this.currentPage > this.totalPage) {
        this.currentPage = this.totalPage;
      }
      this.emit();
    },
    getNext() {
      this.currentPage++;
      this.getPage();
    },
    getPrev() {
      this.currentPage--;
      this.getPage();
    },
    calculatePageRangeView() {
      this.displayPages = [];
      var center = this.displayPageSize / 2;
      var fromPageNumber = this.currentPage - center;
      var toPageNumber = this.currentPage + center;
      if (fromPageNumber <= 0) {
        fromPageNumber = 1;
        toPageNumber = this.displayPageSize;
      }
      if (toPageNumber >= this.totalPage) {
        toPageNumber = this.totalPage;
      }
      if (this.totalPage <= this.displayPageSize) {
        fromPageNumber = 1;
        toPageNumber = this.totalPage;
      }

      for (var i = fromPageNumber; i <= toPageNumber; i++) {
        this.displayPages.push(i);
      }
    }
  }
};
</script>