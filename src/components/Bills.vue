<template>
  <div class="container-fluid">
      <div class="card" v-for="bill in bills" :key="bill.id">
          <div class="card-body">
              {{bill.name}} {{bill.amount}}
          </div>
      </div>
  </div>
</template>

<script>
export default {
    name: 'Bills',
    data: () => {
        return {
            bills: [],
            billModel: {id:0}
        }
    },
    created: function () {
        this.bills.push({id:1, name:'Association', amount:'500.00'})
        this.bills.push({id:2, name:'DTE', amount:'100.00'})
        this.bills.push({id:3, name:'Comcast', amount:'125.00'})
        this.bills.push({id:4, name:'Netflix', amount:'14.99'})
        this.bills.push({id:5, name:'Car Note', amount:'303.00'})

    }

}
</script>

<style>

</style>