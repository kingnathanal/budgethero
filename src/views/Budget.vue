<template>
  <div class="budget">
    <BudgetHome/>
  </div>
</template>

<script>
// @ is an alias to /src
import BudgetHome from '@/components/BudgetHome.vue'

export default {
  name: 'Budget',
  components: {
    BudgetHome
  }
}
</script>
