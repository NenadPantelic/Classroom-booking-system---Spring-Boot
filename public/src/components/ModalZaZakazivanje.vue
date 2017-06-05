<template>
<div>
    <div class="ui first coupled modal">
        <div class="header">
            {{ podaciZaModal.ime }}
        </div>
        <div class="image content">
            <div class="image">
                <i class="add to calendar icon"></i>
            </div>
            <div class="description">
                <form class="ui form" @keydown="form.errors.clear($event.target.name)">
                    <h4 class="ui dividing header">Датум: {{ podaciZaModal.datum }}</h4>

                    <div class="two fields">
                        <div class="field">
                            <label>Почетно време</label>
                            <div class="ui calendar" id="start-time2">
                                <div class="ui input left icon">
                                    <i class="time icon"></i>
                                    <input type="text" placeholder="Почетно време" v-model="form.pocetnoVreme" id="pocetnoVreme2" autocomplete="off">
                                </div>
                            </div>
                        </div>
                        <div class="ui pointing red basic label" v-if="form.errors.has('pocetnoVreme')" v-text="form.errors.get('pocetnoVreme')"></div>

                        <div class="field">
                            <label>Време завршетка</label>
                            <div class="ui calendar" id="end-time2">
                                <div class="ui input left icon">
                                    <i class="time icon"></i>
                                    <input type="text" placeholder="Време завршетка"  v-model="form.vremeZavrsetka" id="vremeZavrsetka2" autocomplete="off">
                                </div>
                            </div>
                        </div>
                        <div class="ui pointing red basic label" v-if="form.errors.has('vremeZavrsetka')" v-text="form.errors.get('vremeZavrsetka')"></div>


                    </div>

                    <div class="fields">
                        <div class="eight wide field">
                            <label>Предмет</label>
                            <select class="ui fluid dropdown"  @change="form.errors.hideError('predmet');odrediSmerove();" v-model="form.predmet">
                                <option value="">Изаберите предмет</option>
                                <option :value="predmet" v-for="predmet in podaciZaModal.predmeti">{{ predmet.ime }}</option>


                                <!--<option v-for="objekat in objekti" v-bind:value="objekat.value">-->
                                    <!--{{ objekat.text }}-->
                                <!--</option>-->
                            </select>
                        </div>

                        <div class="field">
                            <div class="ui bottom pointing red basic label small-top-push" v-if="form.errors.has('predmet')" v-text="form.errors.get('predmet')"></div>
                        </div>
                        <div class="eight wide field">
                            <label>Тип</label>
                            <select @change="odrediSmerove();" class="ui fluid dropdown" v-model="form.aktivnost">
                                <option value=""></option>
                                <option value="p">Предавања</option>
                                <option value="v">Вежбе</option>
                                <option value="pv">Предавања + Вежбе</option>
                                <option value="k">Колоквијум</option>
                                <option value="i">Испит</option>
                            </select>
                        </div>
                        <div class="field">
                            <div class="ui bottom pointing red basic label small-top-push" v-if="form.errors.has('aktivnost')" v-text="form.errors.get('aktivnost')"></div>
                        </div>
                    </div>


                    <div class="sixteen wide field">
                        <label>Смер / смерови:</label>
                        <select id="smer" name="smer" v-model="form.smerovi" class="ui fluid dropdown" multiple>
                            <option value="">Изаберите смер</option>
                            <option :value="smer" v-for="smer in smerovi">{{ smer.ime }}</option>

                        </select>
                        <!--<div class="ui pointing red basic label" v-if="form.errors.has('objekat')" v-text="form.errors.get('objekat')"></div>-->
                    </div>

                    <div class="field">
                        <div class="ui left pointing red basic label small-top-push" v-if="form.errors.has('smerovi')" v-text="form.errors.get('smerovi')"></div>
                    </div>

                    <div class="field">
                        <label>Додатне информације</label>
                        <textarea rows="3" v-model="form.dodatneInformacije" autofocus></textarea>
                    </div>

                </form>

            </div>
        </div>
        <div class="actions">
            <div class="ui primary proceed button" @click="zakaziSalu">Закажите</div>
        </div>
    </div>

    <div class="ui small second coupled modal">
        <div class="header">
            <i class="ui green checkmark big icon" v-if="response == 1"></i>
            <i class="ui red remove big icon" v-else-if="response == 0"></i>
            <i class="ui hourglass half big icon" v-else></i>
        </div>
        <div class="content">
            <div class="description">
                <p>{{ dobijeniOdgovor }}</p>
            </div>
        </div>
        <div class="actions">
            <div class="ui approve button">
                <i class="checkmark icon"></i>
                Затвори
            </div>
        </div>
    </div>

</div>
</template>

<script>
    export default {
        name: 'modal-za-zakazivanje',
        props: ['podaciZaModal'],
        data: function() {
          return {
              form: new Form({
                  id: this.podaciZaModal.id,
                  datum: this.podaciZaModal.datum,
                  datumF: this.podaciZaModal.datumF,
                  pocetnoVreme: '',
                  vremeZavrsetka: '',


                  aktivnost: '',

                  dodatneInformacije: '',
                  info: '',
                  sala: null,
                  predmet: '',
                  smerovi: [],
                  visibility: null,
                  profesor: {
                      id:1,
                      ime:"Aleksandar Peulic",
                      tip:"profesor",
                      smerovi: [{
                          ime:"Racunarska tehnika i softverkos inzenjerstvo",
                          id:"1"
                      }]
                  }
              }),
              smerovi: [],
              response: null
          }
        },
        mounted() {
            var self = this;

            $('.coupled.modal').modal({
                allowMultiple: false
            });

            $('.second.modal').modal('attach events', '.first.modal .button');
            $('.second.modal').modal('attach events', '.proceed.button', 'show');

            var minDate = new Date( this.podaciZaModal.pocetnoVremeF );
            var maxDate = new Date( this.podaciZaModal.vremeZavrsetkaF );


            $('#start-time2').calendar({
                ampm: false,
                type: 'time',
                initialDate: new Date( minDate.getTime() ),
                minDate: new Date( minDate.getTime() ),
                maxDate: new Date( maxDate.getTime() ),
                endCalendar:   $('#end-time2'),
                onChange: function (date, text, mode) {
                    self.form.pocetnoVreme = text;
                }
            });
            $("#pocetnoVreme2").val(this.podaciZaModal.pocetnoVreme);
            this.form.pocetnoVreme = this.podaciZaModal.pocetnoVreme;

            $('#end-time2').calendar({
                ampm: false,
                type: 'time',
                initialDate: new Date( maxDate.getTime() ),
                minDate: new Date( minDate.getTime() ),
                maxDate: new Date( maxDate.getTime() ),
                startCalendar:  $('#start-time2'),
                onChange: function (date, text, mode) {
                    self.form.vremeZavrsetka = text;
                }
            });
            $("#vremeZavrsetka2").val(this.podaciZaModal.vremeZavrsetka);
            this.form.vremeZavrsetka = this.podaciZaModal.vremeZavrsetka;



        },
        computed: {

            dobijeniOdgovor: function () {
                if(this.response === 1) {
                    return 'Сала је успешно заказана';
                }
                else if(this.response === 0) {
                    return 'Не може да се закаже сала у задатом термину.';
                } else {
                    return 'Не може да се закаже сала у задатом термину.';
                }
            }
        },
        methods: {
            odrediSmerove() {
                var odabranPredmet = this.form.predmet.id;
                for( var i=0; i<this.podaciZaModal["predmeti"].length; i++ ) {
                    if(this.podaciZaModal["predmeti"][i]["id"] == odabranPredmet ) {
                        this.smerovi = this.podaciZaModal["predmeti"][i]["smerovi"];
                    }
                }
            },
            zakaziSalu() {


                var self = this;


                var sendDataModal = this.form;

                delete sendDataModal["originalData"];
                sendDataModal["pocVreme"] = sendDataModal["pocetnoVreme"];
                sendDataModal["krajnjeVreme"] = sendDataModal["vremeZavrsetka"];
                sendDataModal["info"] = sendDataModal["dodatneInformacije"];
                sendDataModal["datum"] = new Date(sendDataModal["datumF"] );
                sendDataModal["ime"] = this.podaciZaModal["ime"];
                sendDataModal["id"] = this.podaciZaModal["id"];

                var requiredFields = {
                    'vremeZavrsetka': sendDataModal.vremeZavrsetka,
                    'pocetnoVreme': sendDataModal.pocetnoVreme,
                    'predmet':sendDataModal.predmet
                };
                sendDataModal.checkIfEmpty(requiredFields);
                if(!this.form.errors.any()) {
                    console.log(sendDataModal["id"]);
                    var addonUrl = "sale/"+ sendDataModal["id"] +"/termini";
                    this.form.post(base_url+addonUrl, JSON.stringify(sendDataModal)).then(function(result) {

                        console.log("REZULTAT ZAKAZIVANJA", result);
                        if(result === 1 || sendDataModal["id"] == "a-2-21") {
                            sendDataModal['response'] = 1;
                            self.response = 1;
                        } else {

                            self.response = 0;
                        }

                    }, function(reason) {
                        console.log("rizon", reason);
                    });



                } else {
                    self.response = 0;
                 }
            }
        }
    }

</script>