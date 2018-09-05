<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Offerte Tutoraggi</title>

<#include "importCss.ftl">

</head>
<body class="smoothscroll enable-animation">

<div id="wrapper">
   <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>LISTA TUTOARAGGI </h1>

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
                    <form id="querystring" class="pr-15 pl-15 m-0 mt-32" method="get" action="print.php">
                        <fieldset>
                            <div class="row justify-content-around">
                                <div class="row col-auto mb-0">
                                    <h4 class="mt-9">Risultati: </h4>
                                    <label class="col">
                                        <!-- select -->
                                        <div class="fancy-form fancy-form-select">
                                            <select class="form-control mr-15">
                                                <option value="5">5 per pagina &nbsp;</option>
                                                <option value="10">10 per pagina &nbsp;</option>
                                                <option value="20">20 per pagina &nbsp;</option>
                                            </select>
                                        </div>
                                    </label>
                                </div>
                                <div class="row col-auto mb-0">
                                    <h4 class="mt-9">Azienda : </h4>
                                    <label class="col-auto">
                                        <!-- select -->
                                        <div class="fancy-form fancy-form-select">
                                            <select class="form-control select2">
                                                <option value="">Tutte le Aziende</option>
                                                <option value="1">Dolci Aveja</option>
                                                <option value="2">Gunpowder</option>
                                                <option value="3">Tirocinio interno</option>
                                                <option value="4">CONSEL - Consorzio ELIS</option>
                                                <option value="5">PACARO Srl</option>
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
                                            <select class="form-control select2">
                                                <option value="">Tutte le sedi disponibili</option>
                                                <option value="RM">Roma</option>
                                                <option value="AQ">L'Aquila</option>
                                                <option value="PE">Pescara</option>
                                                <option value="CH">Chieti</option>
                                                <option value="AN">Ancona</option>
                                            </select>

                                            <i class="fancy-arrow-"></i>
                                        </div>

                                    </label>
                                </div>
                                <div class="row col-4 mb-0 pl-0">
                                    <h4 class="mt-9">Da :</h4>
                                    <label class="col input-group">
                                        <input type="date" name="datainizio"
                                               value="2018-07-27"
                                               min="2018-01-01" max="2018-12-31" class="form-control"/>
                                    </label>
                                </div>
                                <div class="row col-4 mb-0">
                                    <h4 class="mt-9">A :</h4>
                                    <label class="col input-group pr-0">
                                        <input type="date" name="datainizio"
                                               value="2018-07-29"
                                               min="2018-01-01" max="2018-12-31" class="form-control"/>
                                    </label>
                                </div>
                            </div>
                        </fieldset>

                        <footer class="bt-0">
                            <button type="submit" form="querystring"
                                    class="btn btn-blue b-blu btn-lg pull-right float-right"><i
                                    class="fa fa-check"></i> Filtra
                            </button>
                            <button type="reset" form="querystring" class="btn btn-red btn-lg pull-right float-left"><i
                                    class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </form>
                </div>
            </div>
            <div class="row hidden-xl-up">
                <div class="col mb-15 box-white border radius-5">
                    <div class="row pr-10 pl-10 pt-5 pb-5">
                        <i id="filtra-sm" class="fa fa-plus-circle fs-25 pt-7 mr-10"></i>
                        <h3 class="mb-0">Filtra la lista dei tirocini</h3>
                    </div>
                    <form id="querystring-sm" class="pr-15 pl-15 m-0 mt-32" method="get" action="print.php">
                        <fieldset>
                            <div class="row pl-15">
                                <div class="row col-auto mb-0">
                                    <h4 class="mt-9">Risultati: </h4>
                                    <label class="col-auto">
                                        <!-- select -->
                                        <div class="fancy-form fancy-form-select">
                                            <select class="form-control mr-15">
                                                <option value="5">5 per pagina &nbsp;</option>
                                                <option value="10">10 per pagina &nbsp;</option>
                                                <option value="20">20 per pagina &nbsp;</option>
                                            </select>
                                        </div>
                                    </label>
                                </div>
                                <div class="d-inline col-auto mb-0 pl-0">
                                    <h4 class="mt-9 d-inline">Azienda : </h4>
                                    <label class="col-auto d-inline">
                                        <!-- select -->
                                        <div class=" d-inline fancy-form fancy-form-select">
                                            <select class="form-control select2">
                                                <option value="">Tutte le Aziende</option>
                                                <option value="1">Dolci Aveja</option>
                                                <option value="2">Gunpowder</option>
                                                <option value="3">Tirocinio interno</option>
                                                <option value="4">CONSEL - Consorzio ELIS</option>
                                                <option value="5">PACARO Srl</option>
                                            </select>

                                            <i class="fancy-arrow-"></i>
                                        </div>

                                    </label>
                                </div>
                            </div>

                            <div class="row pl-15">
                                <div class="row col mb-0 mr-15">
                                    <h4 class="mt-9 pr-15">Sede Tirocinio :</h4>
                                    <label class="col pl-0">
                                        <!-- select -->
                                        <div class="fancy-form fancy-form-select">
                                            <select class="form-control select2">
                                                <option value="">Tutte le sedi disponibili</option>
                                                <option value="RM">Roma</option>
                                                <option value="AQ">L'Aquila</option>
                                                <option value="PE">Pescara</option>
                                                <option value="CH">Chieti</option>
                                                <option value="AN">Ancona</option>
                                            </select>

                                            <i class="fancy-arrow-"></i>
                                        </div>

                                    </label>
                                </div>
                                <div class="input-group col-md-auto col-lg pl-0 mb-0">
                                    <input type="text" class="form-control" aria-label=""
                                           placeholder="Cerca nella lista" name="search">
                                    <span class="input-group-btn">
                                            <button class="btn btn-primary material-ico" type="submit">
                                                <i class="material-icons">search</i>
                                            </button>
                                        </span>
                                </div>
                            </div>

                            <div class="row pl-15 pr-10 mb-0">
                                <div class="row col-12 col-md-5 mb-0 mr-15">
                                    <h4 class="mt-9">Da :</h4>
                                    <label class="col input-group">
                                        <input type="date" name="datainizio"
                                               value="2018-07-27"
                                               min="2018-01-01" max="2018-12-31" class="form-control"/>
                                    </label>
                                </div>
                                <div class="row col-12 col-md-5 mb-0">
                                    <h4 class="mt-9">A :</h4>
                                    <label class="col input-group pr-0">
                                        <input type="date" name="datainizio"
                                               value="2018-07-29"
                                               min="2018-01-01" max="2018-12-31" class="form-control"/>
                                    </label>
                                </div>
                            </div>
                        </fieldset>

                        <footer class="bt-0">
                            <button type="submit" form="querystring"
                                    class="btn btn-blue b-blu btn-lg pull-right float-right"><i
                                    class="fa fa-check"></i> Filtra
                            </button>
                            <button type="reset" form="querystring" class="btn btn-red btn-lg pull-right float-left"><i
                                    class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </form>
                </div>
            </div>
            <div class="linea-divisione mt-0"></div>
            <div class="row">
                <!-- Pagination -->
                <ul class="pagination col-auto mr-15 mt-5 pl-15">
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                    <li class="page-item"><a class="page-link" href="#">Tutto</a></li>
                </ul>
            </div>
            <div id="blog" class="clearfix blog-isotope blog-isotope-2">

                <!-- POST ITEM -->
                <#list offerte as offerta>
                <div class="blog-post-item radius-5 box-white border p-15">


                    <h2><a href="#" class="uppercase">${offerta.titolo}</a></h2>

                    <ul class="blog-post-info list-inline">
                        <li>
                            <a href="#">
                                <i class="fa fa-clock-o"></i>
                                <span class="font-lato">${offerta.updateDate}</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-industry"></i>
                                <span class="font-lato">${offerta.aziendaOspitante}</span>
                            </a>
                        </li>
                    </ul>

                    <p>${offerta.descrizioneBreve}
                    </p>
                    <p>Per eventuali candidature o richieste di informazioni rivolgersi
                        a: a.pasanisi@gp-start.it</p>
                    <p><i class="fa fa-info-circle griggio"></i><b> Contatto aziendale:</b> ${offerta.nomeTutoreAziendale} ${offerta.cognomeTutoreAziendale}
                        ${offerta.emailTutoreAziendale}</p>
                    <a href="/tirocinio?ID=${offerta.IDOffertaTirocinio}" class="btn btn-reveal btn-default b-0 btn-shadow-1">
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
<script src="js/internshiptutor.js"></script>
</body>
</html>