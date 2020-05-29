<template>
  <div class="budget-home bg-light">
    <div class="container pt-4">
      <div class="row">
        <div class="col">
          <div class="card">
            <div class="card-header text-left">Budget Overview</div>
            <div class="card-body">
              Total Bills: ${{totalBills}}
              <br />
              Total Income: ${{totalIncome}}
              <br />
              Remaining Income: ${{spendingAvailable}}
              <br />
              {{incomeData.name}}
              {{incomeData.amount}}
            </div>
          </div>
        </div>
        <div class="col-4">
          <div class="card">
            <div class="card-header text-left bg-info text-white">Sources of Income</div>
            <div class="card-body text-left">
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
              </form>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-4">
          <Bills/>
        </div>
        <div class="col"></div>
      </div>
    </div>
  </div>
</template>

<script>
import Bills from '@/components/Bills.vue'

export default {
  name: "BudgetHome",
  components: {Bills},
  data: () => {
    return {
      incomes: [
        { id: 1, name: "Bank 1", amount: 1000 },
        { id: 2, name: "Bank 2", amount: 500 },
        { id: 3, name: "Shoe Box", amount: 250 },
        { id: 4, name: "Bible", amount: 50 }
      ],
      bills: [{ name: "Credit Card", amount: 100 }],
      incomeData : {
        id:0,
        name:'',
        amount:''
      }
    };
  },
  methods: {
    createIncomeRow: function() {
      document
        .querySelectorAll(".income-inputs")
        .forEach(x => x.classList.remove("is-invalid"));

      if (this.incomeData.name === '' || this.incomeData.amount === '') {
        console.log('These fields can not be empty')
      } else if(isNaN(this.incomeData.amount)) {
        console.log('The amount must be a valid number')
      } else {
        let _income = Object.assign({},this.incomeData)
        _income.id = this.incomes.length + 1
        this.incomes.push(_income)
        this.clearIncomeForm()
      }
    },
    updateIncomeRow: function(id) {
      this.incomes.forEach(x => {
        if(x.id === id) {
          this.incomeData = x
        }
      })
    },
    deleteIncomeRow: function(id) {
      this.incomes.forEach((x,i) => {
        if(x.id === id) {
          this.incomes.splice(i,1)
        }
      })
    },
    clearIncomeForm: function() {
      this.incomeData.id = 0
      this.incomeData.name = ''
      this.incomeData.amount = ''
    }
  },
  computed: {
    totalIncome: function() {
      let total = 0;
      this.incomes.forEach(x => (total += Number(x.amount)));
      return total;
    },
    totalBills: function() {
      let total = 0;
      this.bills.forEach(x => (total += Number(x.amount)));
      return total;
    },
    spendingAvailable: function() {
      return this.totalIncome - this.totalBills;
    }
  }
};
</script>

<style scoped>
.budget-home {
  min-height: 90vh;
}
.income-list {
  padding-inline-start: 0;
}
.income-list li {
  list-style-type: none;
}
</style>