<template>
<div class="ui stacked segment">
    <h2 class="ui olive ribbon label">Претражите доступну салу</h2>

    <form class="ui form search-form"  @submit.prevent="onSubmit" @keydown="form.errors.clear($event.target.name)">

        <div class="two column row fields">
            <div class="column field">
                <label>Датум </label>
                <div class="ui calendar" id="date">
                    <div class="ui input left icon">
                        <i class="calendar icon"></i>
                        <input type="text" id="datum" name="datum" v-model="form.datum" @click="form.errors.hideError('datum')" placeholder="Одаберите датум" autocomplete="off">
                    </div>
                </div>
                <div class="ui pointing red basic label"  v-if="form.errors.has('datum')"  v-text="form.errors.get('datum')"></div>
            </div>
        </div>
        <div class="two column row fields">
            <div class="column field">
                <label>Почетно време</label>
                <div class="ui calendar" id="start-time">
                    <div class="ui input left icon">
                        <i class="time icon"></i>
                        <input type="text" placeholder="Почетно време" v-model="form.pocetnoVreme" id="pocetnoVreme" autocomplete="off">
                    </div>
                </div>
            </div>

            <div class="column field">
                <label>Време завршетка</label>
                <div class="ui calendar" id="end-time">
                    <div class="ui input left icon">
                        <i class="time icon"></i>
                        <input type="text" placeholder="Време завршетка" v-model="form.vremeZavrsetka" id="vremeZavrsetka" autocomplete="off">
                    </div>
                </div>
            </div>
        </div>

        <div class="ui segments">
            <div class="ui two column grid secondary segment small form">
                <div class="eight wide column">
                    <div class="ui toggle checkbox">
                        <input type="checkbox" name="projektori"  v-model="form.sadrziProjektor" tabindex="1">
                        <label>Потребан пројектор?</label>
                    </div>
                </div>
                <div class="column">
                    <div class="ui left icon input">
                        <input type="number" name="brojMesta" v-model.number="form.brojMesta" max="999" placeholder="Мин. број места">
                        <i class="users icon"></i>
                    </div>
                </div>
            </div>
            <div class="ui two column grid secondary segment  small form">
                <div class="eight wide column">
                    <div class="ui toggle checkbox">
                        <input type="checkbox" name="racunari" tabindex="0" v-model="form.salaSaRacunarima" @change="dozvoliUnosRacunara = !dozvoliUnosRacunara">
                        <label>Сала са рачунарима?</label>
                    </div>
                </div>
                <div class="column">
                    <div class="ui left icon input">
                        <input type="number" name="brojRacunara" max="999" v-model.number="form.brojRacunara" :disabled="dozvoliUnosRacunara" placeholder="Мин. број рачунара">
                        <i class="laptop icon"></i>
                    </div>
                </div>
            </div>
        </div>
        <div class="fields">
            <div class="field">
                <label>Претрага по објекту:</label>
                <select id="objekat" name="objekat" class="ui fluid dropdown" @change="form.errors.hideError('objekat')"  v-model="form.objekat"  multiple>
                    <option v-for="obj in objekti" v-bind:value="obj.value">
                        {{ obj.text }}
                    </option>
                </select>
            </div>
            <div class="field">
                <div class="ui left pointing red basic label small-top-push" v-if="form.errors.has('objekat')" v-text="form.errors.get('objekat')"></div>
            </div>
        </div>

        <button type="submit" class="ui button" tabindex="2"  :disabled="form.errors.any()">Претражи</button>
    </form>




</div>

</template>

<script>

    export default {
        name: 'forma-za-zakazivanje',
        props: ['slobodneSale'],
        data: function() {
            return {

                //Form related
                form: new Form({
                    datum: '',
                    datumF: '',
                    pocetnoVreme: '',
                    pocetnoVremeF: null,
                    vremeZavrsetka: '',
                    vremeZavrsetkaF: '',
                    objekat: ["obj-a", "obj-b", "obj-c", "obj-d"],
                    sadrziProjektor: false,
                    brojRacunara: null,
                    salaSaRacunarima: false,
                    brojMesta: null
                }),

                dozvoliUnosRacunara: true,
                objekti: [
                    { text: 'Објекат А', value: 'obj-a' },
                    { text: 'Објекат Б', value: 'obj-b' },
                    { text: 'Објекат Ц', value: 'obj-c' },
                    { text: 'Објекат Д', value: 'obj-d' }
                ],


            }
        },
        methods: {
            onSubmit() {

                var sendData = this.form;
                var requiredFields = {
                    'datum': sendData.datum,
                    'objekat': sendData.objekat
                };

                sendData.checkIfEmpty(requiredFields);
                if(!this.form.errors.any()) {
                    delete sendData['originalData'];
                    delete sendData['errors'];
                    sendData['response'] = 1;
                    this.form.post('src/data/statuses.json', sendData, 'searched', this);
                     //   .then(result => this.$emit('searched', result));

                }

                console.log(JSON.stringify(sendData));


            }
        },
        created: function() {


            //Inicijalizacija vrednosti nakon submitovanja
            if(this.slobodneSale.response === 1) {
                this.form.datum = this.slobodneSale.datum;
                this.form.pocetnoVremeF = this.slobodneSale.pocetnoVremeF;
                this.form.pocetnoVreme = this.slobodneSale.pocetnoVreme;
                this.form.vremeZavrsetka = this.slobodneSale.vremeZavrsetka;
                this.form.vremeZavrsetkaF = this.slobodneSale.vremeZavrsetkaF;
                this.form.sadrziProjektor = this.slobodneSale.sadrziProjektor;
                this.form.objekat = this.slobodneSale.objekat;
                this.form.salaSaRacunarima = this.slobodneSale.salaSaRacunarima;
                this.form.brojRacunara = this.slobodneSale.brojRacunara;
            }
        },
        mounted(){

            //Calendar semantic-ui plugin
            var self = this;
            var today = new Date();
            $('#date').calendar({
                type: 'date',
                initialDate: new Date( ),
                minDate: new Date(today.getFullYear(), today.getMonth(), today.getDate() ),
                onChange: function (date, text, mode) {
                    self.form.datum = text;
                    self.form.datumF = date;
                }
            });

            $('#start-time').calendar({
                ampm: false,
                type: 'time',
                endCalendar:   $('#end-time'),
                onChange: function (date, text, mode) {
                    self.form.pocetnoVremeF = date;
                    self.form.pocetnoVreme = text;
                }
            });


            $('#end-time').calendar({
                ampm: false,
                type: 'time',
                startCalendar:  $('#start-time'),
                onChange: function (date, text, mode) {
                    self.form.vremeZavrsetkaF = date;
                    self.form.vremeZavrsetka = text;
                }
            });

            //Multiple dropdown select
            $(".dropdown").dropdown({
                allowAdditions: true
            });

        }
    }
</script>

<style>
    .small-top-push {
        margin-top: 27px !important;
    }
    .ui.toggle.checkbox > label:before,  .ui.toggle.checkbox > label:after, .ui.toggle.checkbox > input{
        top: 7px;
    }
    @media screen and (max-width: 767px) {
        .search-form .button {
            margin-top: 10px;
        }
    }
</style>