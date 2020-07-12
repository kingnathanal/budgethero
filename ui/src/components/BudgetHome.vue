<template>
  <div class="budget-home bg-light">
    <div class="container pt-4">
      <div class="row">
        <div class="col">
          <div class="card border-0 bg-transparent">
            <div class="card-body bg-transparent">
              <div class="row">
                <div class="col"><canvas id="pieChart" width="400" height="400"></canvas></div>
                <div class="col"><canvas id="barChart" width="400" height="400"></canvas></div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-4">
          <div class="card">
            <div class="card-header text-left bg-info text-white">Summary</div>
            <div class="card-body text-left p-1
            ">
              <div class="m-2 p-3 border shadow-sm">
                <h5 class="text-primary">Total Monthly Income</h5>
                <span class="h2">${{totalIncome}}</span>
              </div>
              <div class="m-2 p-3 border shadow-sm">
                <h5 class="text-primary">Total Monthly Expenses</h5>
                <span class="h2">${{totalBills}}</span>
              </div>
              <div class="m-2 p-3 border shadow-sm">
                <h5 class="text-primary">Total Monthly Savings</h5>
                <span class="h2">${{totalSavings}}</span>
              </div>
              <div class="m-2 p-3 border shadow-sm">
                <h5 class="text-primary">Cash Balance</h5>
                <span class="h2">${{spendingAvailable}}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row mt-3">
        <div class="col">
          <div class="card">
            <div class="card-header">Monthly Income</div>
            <div class="card-body p-2">
              <table class="table table-bordered w-100 text-left">
                <thead class="thead-dark">
                  <tr>
                    <th class="w-50">Item</th>
                    <th class="w-25">Amount</th>
                    <th class="w-25"></th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="income in incomes" :key="income.id">
                    <td>{{income.name}}</td>
                    <td>${{income.amount}}</td>
                    <td><button class="btn btn-sm btn-danger" :data-id="income.id" @click="deleteIncomeRow(income.id)">x</button></td>
                  </tr>
                </tbody>
              </table>
              <div class="alert alert-success m-2">Enter in a new source of income to add to your budget</div>
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
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-header">Monthly Expenses</div>
            <div class="card-body p-2">
              <table class="table table-bordered w-100 text-left">
                <thead class="thead-dark">
                  <tr>
                    <th class="w-50">Item</th>
                    <th class="w-25">Due Date</th>
                    <th class="w-25">Amount</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="bill in bills" :key="bill.id">
                    <td>{{bill.name}}</td>
                    <td>{{bill.dueDate}}</td>
                    <td>${{bill.amount}}</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            <div class="card-header">Monthly Savings</div>
            <div class="card-body p-2">
              <table class="table table-bordered w-100 text-left">
                <thead class="thead-dark">
                  <tr>
                    <th class="w-50">Item</th>
                    <th class="w-25">Amount</th>
                    <th class="w-25"></th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="saving in savings" :key="saving.id">
                    <td>{{saving.name}}</td>
                    <td>${{saving.amount}}</td>
                    <td> </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Chart from 'chart.js';

export default {
  name: "BudgetHome",
  //components: {Bills: () => import('@/components/Bills') },
  data: () => {
    return {
      incomes: [
        { id: 1, name: "Check 1", amount: 1500 },
        { id: 2, name: "Check 2", amount: 500 }
      ],
      bills: [{id:6, name: "Credit Card", amount: 100,dueDate:'01/01' }],
      savings: [
        {id:1,name:'Shoe Box',amount:200},
        {id:2,name:'Bible',amount:50}
      ],
      incomeData : {
        id:0,
        name:'',
        amount:''
      },
      myChart: null,
      myChart2:null
    };
  },
  created: function () {
        this.bills.push({id:1, name:'Association', amount:500.00,dueDate:'01/15'})
        this.bills.push({id:2, name:'DTE', amount:300.00,dueDate:'01/01'})
        this.bills.push({id:3, name:'Comcast', amount:125.00,dueDate:'01/15'})
        this.bills.push({id:4, name:'Netflix', amount:15.00,dueDate:'01/01'})
        this.bills.push({id:5, name:'Car Note', amount:400.00,dueDate:'01/15'})

          
  },
  mounted () {
    var ctx = document.getElementById('pieChart');
    this.myChart = new Chart(ctx, {
      type: 'doughnut',
      data: {
        datasets: [{
          data: [this.totalIncome,this.totalBills],
          backgroundColor: ['rgb(0 123 255)','rgb(63 224 208)'],
          hoverBackgroundColor: ['rgb(0 123 255)','rgb(63 224 208)']
        }],
        labels: ['Income','Expenses']
      }
    });

    var ctx2 = document.getElementById('barChart');
    this.myChart2 = new Chart(ctx2, {
      type: 'bar',
      data: {
        datasets: [{
          label: 'Budget Overview',
          data: [[0,this.totalIncome],[0,this.totalBills]],
          fill:false,
          backgroundColor: ['rgb(0 123 255)','rgb(63 224 208)']
        }],
        labels: ['Income','Expenses']
      }
    });
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

        this.updateChartData()
        this.clearIncomeForm()
      }
    },
    updateIncomeRow: function(id) {
      this.incomes.forEach(x => {
        if(x.id === id) {
          this.incomeData = x
          this.updateChartData()
        }
      })
    },
    deleteIncomeRow: function(id) {
      this.incomes.forEach((x,i) => {
        if(x.id === id) {
          this.incomes.splice(i,1)
          this.updateChartData()
        }
      })
    },
    clearIncomeForm: function() {
      this.incomeData.id = 0
      this.incomeData.name = ''
      this.incomeData.amount = ''
    },
    updateChartData: function() {
      this.myChart.data.datasets[0].data = [this.totalIncome,this.totalBills]
      this.myChart2.data.datasets[0].data = [[0,this.totalIncome],[0,this.totalBills]]
      this.myChart.update()
      this.myChart2.update()
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
    totalSavings: function() {
      let total = 0;
      this.savings.forEach(x => (total += Number(x.amount)));
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