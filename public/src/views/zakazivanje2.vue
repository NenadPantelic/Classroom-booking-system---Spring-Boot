<template>

    <div class="ui stackable grid" v-if="searched">

        <spinner :show="loading"></spinner>
        <div class="nine wide computer column sixteen wide tablet column">
            <TabelaSaRezultatima :slobodne-sale="searchedFormData"></TabelaSaRezultatima>
        </div>

        <div class="seven wide computer column sixteen wide tablet column">
        <!-- Forma za zakazivanje -->
            <forma-za-zakazivanje @searched="pretrazenoZakazivanje"></forma-za-zakazivanje>
        </div>
    </div>
    <div class="ui stackable grid" v-else>
        <spinner :show="loading"></spinner>
        <div class="eight wide computer column sixteen wide tablet column">
            <!-- Forma za zakazivanje -->
            <forma-za-zakazivanje @searched="pretrazenoZakazivanje"></forma-za-zakazivanje>
        </div>
        <div class="eight wide computer column sixteen wide tablet column">
            <Obavestenja></Obavestenja>
        </div>


    </div>
</template>

<script>
    import Spinner from '../components/Spinner.vue'
    import Obavestenja from '../components/Obavestenja.vue'
    import FormaZaZakazivanje from '../components/FormaZaZakazivanje.vue'
    import TabelaSaRezultatima from '../components/TabelaSaRezultatima.vue'

    export default {
        components: {
            Spinner,
            Obavestenja,
            FormaZaZakazivanje,
            TabelaSaRezultatima
        },
        data(){
            return {
                loading: true, //set to true
                searched: false,
                searchedFormData: {},
                slobodneSale: []
            }
        },
        created() {
            // axios call here.
        },
        mounted(){
            this.loading = false;
          //  this.searched = true;


        },
        updated(){

        },
        destroyed(){

        },
        computed: {
        },
        methods: {
            pretrazenoZakazivanje(data) {
                    this.loading = true;
                    this.searchedFormData = data;
                    this.slobodneSale = data.dostupneSale;
                    this.searched = data.response;
                    alert(data.pocetnoVreme);
                    //console.log("dejta", data);
                console.log("sale", data);

                this.loading = false;

            }
        }
    }
</script>
