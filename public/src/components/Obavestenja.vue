<template>
    <div class="ui secondary segment">
        <h2 class="ui header">
            <i class="info circle icon"></i>
            <div class="content">
                Обавештења
            </div>
        </h2>
        <div class="ui middle aligned divided list"  v-if="obavestenja.length">
            <div class="item" v-for="obavestenje in obavestenja">

                <div class="right floated content" data-tooltip="Обриши обавештење" data-inverted="">
                    <i class="close icon" @click="obrisiObavestenje(obavestenje.id)"></i>
                </div>
                <div class="content">

                    <div :class="['ui small header ', vratiKlasu(obavestenje.klasa)]">{{obavestenje.poruka}}</div>
                </div>
            </div>
        </div>
        <div class="ui middle aligned divided list" v-else>
            <div class="item">
                <div class="content">
                    Нема нових обавештења.
                </div>
            </div>
        </div>
    </div>

</template>

<script>
    export default {
        data: function() {
            return {
                obavestenja: []
            }
        },
        mounted() {

            //zameni sa konkretnom
            $.getJSON("src/data/obavestenja.json", function (result) { })
                   .then(result => this.obavestenja = result.obavestenja);

        },
        computed: {

        },
        methods: {
            vratiKlasu: function (id) {
                if(id === 1) {
                    return 'teal';
                } else if( id === 2) {
                    return 'red';
                }
                return '';
            },
            obrisiObavestenje: function (id) {
                //@TODO do an ajax request
                this.obavestenja.pop(id);
            }
        }
    }
</script>

<style>
    .ui.divided.list .list>.item, .ui.divided.list>.item {
        padding-top: 15px;
        padding-bottom: 15px;
    }
    .close.icon {
        cursor: pointer;
    }
</style>