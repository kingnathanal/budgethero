<template>
  <div class="container-fluid">
      <div class="card" v-for="bill in bills" :key="bill.id">
          <div class="card-body">
              {{bill.name}} ${{bill.amount}}
          </div>
      </div>
  </div>
<!--
                <table class="table table-sm table-hover">
                <thead class="thead-light">
                  <tr>
                    <th class="w-50">Name</th>
                    <th class="w-25">Amount</th>
                    <th class="w-25"></th>
                  </tr>
                </thead>
                <tr v-for="income in incomes" :key="income.id">
                  <td>{{income.name}}</td>
                  <td>${{income.amount}}</td>
                  <td>
                    <button class="btn btn-sm btn-primary" :data-id="income.id" @click="updateIncomeRow(income.id)">e</button>
                    <button class="btn btn-sm btn-danger" :data-id="income.id" @click="deleteIncomeRow(income.id)">x</button>
                  </td>
                </tr>
                <tfoot>
                  <tr>
                    <th colspan="3" class="thead-light">Total Income: ${{totalIncome}}</th>
                  </tr>
                </tfoot>
              </table>
              <hr />
              <div class="alert alert-success">Enter in a new source of income to add to your budget</div>
              <form @submit.prevent>
                <div class="form-row">
                  <div class="form-group col-6">
                    <label for="name">Name:</label>
                    <input
                      type="text"
                      class="form-control form-control-sm income-inputs income-name-form" v-model="incomeData.name"
                    />
                  </div>
                  <div class="form-group col-6">
                    <label for="name">Amount:</label>
                    <input
                      type="text"
                      class="form-control form-control-sm income-inputs income-amount-form" v-model="incomeData.amount"
                    />
                  </div>
                </div>
                <div class="form-row">
                  <div class="form-group col">
                    <button
                      type="submit"
                      class="btn btn-success btn-sm w-100"
                      @click="createIncomeRow"
                    >+ Add</button>
                  </div>
                </div>
              </form> -->
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