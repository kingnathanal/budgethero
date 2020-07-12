<template>
  <nav class="navbar sticky-top navbar-dark bg-dark">
    <div class="navbar-brand h2 logo">Budget Hero</div>
    <ul class="nav mr-auto">
      <li v-for="(menu,i) in menulinks" :key="i" class="nav-item">
        <router-link class="nav-link" :to="menu.link">{{menu.name}}</router-link>
      </li>
    </ul>
    <div class="menu text-white">
      <button class="btn btn-sm btn-outline-light">LOGIN</button>
    </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
  data: () => {
    return {
      menulinks: [
        { name: "Home", link: "/" },
        { name: "About", link: "/about" },
        { name: "MyBudget", link: "/budgets" }
      ]
    };
  }
};
</script>

<style>
</style>