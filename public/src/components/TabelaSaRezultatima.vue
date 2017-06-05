<template>
    <div>

        <div v-if="objA(slobodneSale.dostupneSale).length">
            <h4 class="ui horizontal divider header">
                <i class="building outline icon"></i>
                Објекат A
            </h4>
            <table class="ui selectable celled table">
                <thead>
                <tr>
                    <th>Сала</th>
                    <th>Број места</th>
                    <th>Пројектор?</th>
                    <th>Рачунари?</th>
                    <th>Број рачунара</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in objA(slobodneSale.dostupneSale)">
                    <td class="sala-ime">{{ item.ime }}</td>
                    <td>{{ item.brMesta }}</td>
                    <td>{{ item.sadrziProjektor ? 'Да':'Не'}}</td>
                    <td>{{ item.salaSaRacunarima ? 'Да':'Не' }}</td>
                    <td>{{ item.brRacunara }}</td>
                    <td>
                        <div class="ui animated teal button" @click="nastaviZakazivanje(item.id, item.ime)">
                            <div class="visible content">Закажите</div>
                            <div class="hidden content">
                                <i class="right arrow icon"></i>
                            </div>
                        </div>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
        <br />
        <div v-if="objB(slobodneSale.dostupneSale).length">
            <h4 class="ui horizontal divider header">
                <i class="tag icon"></i>
                Objekat B
            </h4>
            <table class="ui selectable celled table">
                <thead>
                <tr>
                    <th>Сала</th>
                    <th>Број места</th>
                    <th>Пројектор?</th>
                    <th>Рачунари?</th>
                    <th>Број рачунара</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in objB(slobodneSale.dostupneSale)">
                    <td>{{ item.ime }}</td>
                    <td>{{ item.objekat }}</td>
                    <td>Da</td>
                    <td>300</td>
                    <td>Da</td>
                    <td>
                        <div class="ui animated teal button">
                            <div class="visible content">Zakazite</div>
                            <div class="hidden content">
                                <i class="right arrow icon"></i>
                            </div>
                        </div>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
        <br />
        <div v-if="objC(slobodneSale.dostupneSale).length">
            <h4 class="ui horizontal divider header">
                <i class="tag icon"></i>
                Objekat C
            </h4>
            <table class="ui selectable celled table">
                <thead>
                <tr>
                    <th>Сала</th>
                    <th>Број места</th>
                    <th>Пројектор?</th>
                    <th>Рачунари?</th>
                    <th>Број рачунара</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in objC(slobodneSale.dostupneSale)">
                    <td class="sala-ime">{{ item.ime }}</td>
                    <td>{{ item.objekat }}</td>
                    <td>Da</td>
                    <td>300</td>
                    <td>Da</td>
                    <td>
                        <div class="ui animated teal button">
                            <div class="visible content">Zakazite</div>
                            <div class="hidden content">
                                <i class="right arrow icon"></i>
                            </div>
                        </div>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
        <br />
        <div v-if="objD(slobodneSale.dostupneSale).length">
            <h4 class="ui horizontal divider header">
                <i class="building outline icon"></i>
                Објекат Д
            </h4>
            <table class="ui selectable celled table">
                <thead>
                <tr>
                    <th>Сала</th>
                    <th>Број места</th>
                    <th>Пројектор?</th>
                    <th>Рачунари?</th>
                    <th>Број рачунара</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in objD(slobodneSale.dostupneSale)">
                    <td class="sala-ime">{{ item.ime }}</td>
                    <td>{{ item.brMesta }}</td>
                    <td>{{ item.sadrziProjektor ? 'Да':'Не'}}</td>
                    <td>{{ item.salaSaRacunarima ? 'Да':'Не' }}</td>
                    <td>{{ item.brRacunara }}</td>
                    <td>
                        <div class="ui animated teal button" @click="nastaviZakazivanje(item.id, item.ime)">
                            <div class="visible content">Закажите</div>
                            <div class="hidden content">
                                <i class="right arrow icon"></i>
                            </div>
                        </div>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
        <div v-if="!objA(slobodneSale.dostupneSale).length && !objB(slobodneSale.dostupneSale).length && !objC(slobodneSale.dostupneSale).length && !objD(slobodneSale.dostupneSale).length">
            <h4 class="ui red header">
                <i class="search icon"></i>
                Нема доступних сала
            </h4>
        </div>
        <modal-za-zakazivanje :podaci-za-modal="zakazanaSala"></modal-za-zakazivanje>

    </div>
</template>

<script>
    import ModalZaZakazivanje from './ModalZaZakazivanje.vue';

    export default {
        components: {
            ModalZaZakazivanje
        },
        props: ['slobodneSale'],
        data(){
            return {
                predmeti: new Form({

                }),
                zakazanaSala: {
                    id: null,
                    ime: null,
                    datum: this.slobodneSale.datum,
                    datumF: this.slobodneSale.datumF,
                    pocetnoVreme: this.slobodneSale.pocetnoVreme,
                    pocetnoVremeF: this.slobodneSale.pocetnoVremeF,
                    vremeZavrsetkaF: this.slobodneSale.vremeZavrsetkaF,
                    vremeZavrsetka: this.slobodneSale.vremeZavrsetka
                }
            }
        },
        computed: {
        },
        created() {
            var self = this;
            this.predmeti.post(base_url+'predmeti', JSON.stringify({})).then(function(result) {
                self.predmeti = result;
                self.$emit('predmeti', result);
            }, function(reason) {
                console.log("rizon", reason);
            });
        },
        mounted() {
        },
        methods: {
            nastaviZakazivanje: function(id, ime) {
                this.zakazanaSala["id"] = id;
                this.zakazanaSala["ime"] = ime;
                this.zakazanaSala["predmeti"] = this.predmeti;
               
                $('.first.modal').modal('setting', 'transition', 'horizontal flip').modal('show');
            },
            objA: function(ss) {
                return ss.filter(function (item) {
                    return item.objekat === "obj-a"
                })
            },
            objB: function(ss) {
                return ss.filter(function (item) {
                    return item.objekat === "obj-b"
                })
            },
            objC: function(ss) {
                return ss.filter(function (item) {
                    return item.objekat === "obj-c"
                })
            },
            objD: function(ss) {
                return ss.filter(function (item) {
                    return item.objekat === "obj-d"
                })
            }

        }

    }
</script>

<style>
    .ui.modal>.content>.icon+.description, .ui.modal>.content>.image+.description {
        width: 100%;
    }
    @media screen and (max-width: 767px) {
        .ui.animated.teal {
            position: relative;
            bottom: 80px;
            float: right;
        }
    }

</style>