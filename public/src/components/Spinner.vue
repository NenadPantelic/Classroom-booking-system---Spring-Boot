<template>
    <div :class="[show ? 'ui active dimmer' : 'ui dimmer', 'fixed']" v-show="show">
        <div class="ui text loader">Учитавање</div>
    </div>
</template>

<script>
    export default {
        props: ['show']
    }
</script>

<style>
    .fixed {
        position: fixed !important;
    }
</style>
