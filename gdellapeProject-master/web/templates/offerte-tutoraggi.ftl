<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Offerte Tutoraggi</title>

<#include "importCss.ftl">

</head>
<body class="enable-animation">

<div id="wrapper">
   <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>LISTA TUTORAGGI </h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li>Lista Offerte Tutoraggi</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section id="contenuto-lista-tutoraggi" class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container p-0">
            <h2 class="fw-100 mb-5">Lista delle Offerte di tirocinio disponibili</h2>
            <h5>Questo canale raccoglie le offerte di tirocinio per studenti da parte di azende convenzionate con il
                nostro Dipartimento. Usa i link che seguono per passare a una sezione differente o tornare alla prima
                pagina.</h5>
            <div class="row hidden-lg-down">
                <div class="col mb-15 box-white border radius-5">
                    <div class="row pr-10 pl-10 pt-5 pb-5">
                        <i id="filtra" class="fa fa-plus-circle fs-25 pt-7 mr-10"></i>
                        <h3 class="mb-0">Filtra la lista dei tirocini</h3>
                    </div>
                    <form id="querystring" class="pr-15 pl-15 m-0 mt-32" method="get" action="/listaofferte">
                        <fieldset>
                            <div class="row justify-content-around">
                                <div class="row col-auto mb-0">
                                    <h4 class="mt-9">Risultati: </h4>
                                    <label class="col">
                                        <!-- select -->
                                        <div class="fancy-form fancy-form-select">
                                            <select class="form-control mr-15" name="risultati">
                                                <option value="4">4 per pagina &nbsp;</option>
                                                <option value="8">8 per pagina &nbsp;</option>
                                                <option value="16">16 per pagina &nbsp;</option>
                                            </select>
                                        </div>
                                    </label>
                                </div>
                                <div class="row col-auto mb-0">
                                    <h4 class="mt-9">Azienda : </h4>
                                    <label class="col-auto">
                                        <!-- select -->
                                        <div class="fancy-form fancy-form-select">
                                            <select class="form-control select2" name="azienda">
                                                <option value="">Tutte le Aziende</option>
                                                <#list aziendas as aziendas>
                                                <option value="${aziendas.ragioneSociale}">${aziendas.ragioneSociale}</option>
                                                </#list>
                                                <#--<#list offerteFiltro as offerta>-->
                                                <#--<option value="${offerta.aziendaOspitante}">${offerta.aziendaOspitante}</option>-->
                                                <#--</#list>-->
                                            </select>

                                            <i class="fancy-arrow-"></i>
                                        </div>

                                    </label>
                                </div>
                                <div class="input-group col mb-0">
                                    <input type="text" class="form-control" aria-label=""
                                           placeholder="Cerca nella lista" name="search">
                                    <span class="input-group-btn">
                                            <button class="btn btn-primary material-ico" type="submit">
                                                <i class="material-icons">search</i>
                                            </button>
                                        </span>
                                </div>
                            </div>
                            <div class="row justify-content-around pl-10 pr-10 mb-0">
                                <div class="row col mb-0 mr-15">
                                    <h4 class="mt-9">Sede Tirocinio :</h4>
                                    <label class="col">
                                        <!-- select -->
                                        <div class="fancy-form fancy-form-select">
                                            <select class="form-control select2" name="sede">
                                                <option value="">Tutte le sedi disponibili</option>
                                                <#list offerteFiltro as offerta>
                                                    <option value="${offerta.luogoEffettuazione}">${offerta.luogoEffettuazione}</option>
                                                </#list>
                                            </select>

                                            <i class="fancy-arrow-"></i>
                                        </div>

                                    </label>
                                </div>
                                <div class="row col-4 mb-0 pl-0">
                                    <h4 class="mt-9">Da :</h4>
                                    <label class="col input-group">
                                        <input type="date" name="datainizio"
                                               value=""
                                               min="2018-01-01" class="form-control"/>
                                    </label>
                                </div>
                                <div class="row col-4 mb-0">
                                    <h4 class="mt-9">A :</h4>
                                    <label class="col input-group pr-0">
                                        <input type="date" name="datafine"
                                               value=""
                                               min="2018-01-01" class="form-control"/>
                                    </label>
                                </div>
                            </div>
                        </fieldset>

                        <footer class="bt-0">
                            <button type="submit" form="querystring"
                                    class="btn btn-blue b-blu btn-lg pull-right float-right"><i
                                        class="fa fa-check"></i> Filtra
                            </button>
                            <button class="btn btn-red btn-lg pull-right float-left"><a style="all: unset;" href="/listaofferte?risultati=4&azienda=&search=&sede=&datainizio=&datafine="><i
                                        class="fa fa-times"></i> Annulla</a>
                            </button>
                        </footer>
                    </form>
                </div>
            </div>



            <div class="linea-divisione mt-0"></div>
            <div class="row">
                <!-- Pagination -->

                <ul class="pagination col-auto mr-15 mt-5 pl-15">
                    <#list 1..numeroPagine as x>
                        <#if x == 0 > <#break> </#if>
                    <li class="page-item <#if numeroPagina == x> active </#if>"><a class="page-link" <#if numeroPagina != x> href="/listaofferte?pageid=${x}&risultati=${risultati}&azienda=${azienda}&sede=${sede}&datainizio=${datainizio}&datafine=${datafine}<#if cerca??>$search=${cerca}</#if>"</#if> >${x}</a></li>
                    </#list>
                </ul>
            </div>
            <div id="blog" class="clearfix blog-isotope blog-isotope-2">

                <!-- POST ITEM -->
                <#list offerte as offerta>
                <div class="blog-post-item radius-5 box-white border p-15">


                    <h2><a href="/listaofferte/tirocinio?Tirocinio=${offerta.IDOffertaTirocinio}" class="uppercase">${offerta.titolo}</a></h2>

                    <ul class="blog-post-info list-inline">
                        <li>
                            <a>
                                <i class="fa fa-clock-o"></i>
                                <span class="font-lato">Aggiornata il ${offerta.updateDate?string.short}</span>
                            </a>
                        </li>
                        <li>
                            <a href="/schedaazienda?ID=${offerta.azienda}">
                                <i class="fa fa-industry"></i>
                                <span class="font-lato">${offerta.aziendaOspitante}</span>
                            </a>
                        </li>
                    </ul>

                    <p>${offerta.descrizioneBreve}
                    </p>
                    <p>Per eventuali candidature o richieste di informazioni rivolgersi
                        a:</p>
                    <p><i class="fa fa-info-circle griggio"></i><b> Contatto aziendale:</b> ${offerta.nomeTutoreAziendale} ${offerta.cognomeTutoreAziendale}
                        ${offerta.emailTutoreAziendale}</p>
                    <a href="/listaofferte/tirocinio?Tirocinio=${offerta.IDOffertaTirocinio}" class="btn btn-reveal btn-default b-0 btn-shadow-1">
                        <i class="fa fa-plus"></i>
                        <span>Leggi di pi&ugrave;</span>
                    </a>

                </div>
                </#list>
                <!-- /POST ITEM -->




            </div>
            <div class="linea-divisione"></div>
        </div>
    </section>


    <#include "footer.ftl">
    <!-- /FOOTER -->

</div>


<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
</body>
</html>