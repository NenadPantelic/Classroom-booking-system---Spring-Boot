<template>
  <div>
    <navigacija></navigacija>

      <div class="ui main container begin">
          <router-view class="view"></router-view>
      </div>
  </div>
</template>

<script>
    import Navigacija from './components/Navigacija.vue'
    import zakazivanje from './views/zakazivanje.vue'
    import raspored from './views/raspored.vue'


    export default {
        name: 'app',
        components: {
            Navigacija,
            zakazivanje,
            raspored
        },
        data () {
            return {

            }
        }
    };
</script>


<style>
.begin {
  margin-top: 60px;
}
</style>
