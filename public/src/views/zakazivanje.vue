<template>

    <transition name="slide-right">
    <div class="ui stackable grid">

        <spinner :show="loading"></spinner>
        <div class="nine wide computer column sixteen wide tablet column"  v-if="searched">
            <TabelaSaRezultatima :slobodne-sale="searchedFormData"></TabelaSaRezultatima>
        </div>

        <div :class="[searched ? 'seven' : 'eight',  'wide computer column sixteen wide tablet column']">
        <!-- Forma za zakazivanje -->
            <forma-za-zakazivanje :slobodne-sale="searchedFormData" @searched="pretrazenoZakazivanje"></forma-za-zakazivanje>
        </div>

        <div class="eight wide computer column sixteen wide tablet column" v-if="!searched">
            <Obavestenja></Obavestenja>
        </div>
    </div>
    </transition>
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

            this.loading = false;
            // axios call here.
        },
        mounted(){
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
                this.searched = data.response;

                this.loading = false;
            }
        }
    }
</script>
