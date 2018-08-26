<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Internship Tutor</title>
    <#include "importCss.ftl">
</head>
<body class="smoothscroll enable-animation">
<div id="wrapper">
    <#include "header.ftl">
    <img class="img-fluid mt-140" src="/templates/imgs/internship.jpg">


    <!-- SECTION HEADER TITLE-->
    <section>
        <div class="container">

            <div class="text-center">
                <h1>Benvenuti su <span>Internship Tutor</span>.</h1>
                <h2 class="col-sm-10 offset-sm-1 mb-0 fw-400">Internship Tutor rappresenta un sistema web per la
                    gestione dell'iter completo dei tirocini universitari.</h2>
            </div>

        </div>
    </section>
    <!-- /SECTION HEADER TITLE-->

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container">
            <h2 class="mb-0">Ultime offerte di tirocinio pubblicate</h2>
            <div class="linea-divisione mt-15 mb-25"></div>
        <div id="blog" class="clearfix blog-isotope blog-isotope-2">
                <!-- POST ITEMS -->
                <#list OfferteTirocini as OffertaTirocinio>
                <div class="blog-post-item radius-5 box-white border p-15">

                    <h4><a href="/tirocinio?ID=${OffertaTirocinio.IDOffertaTirocinio}" class="uppercase"> ${OffertaTirocinio.titolo}</a></h4>

                    <ul class="text-job list-inline mb-5">
                        <li>
                            <a href="#">
                                <i class="fa fa-clock-o"></i>

                            <#--o il periodo di inizio o la data di publicazione-->

                                <span class="font-lato">${OffertaTirocinio.periodoInizio}</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-industry"></i>
                                <span class="font-lato">${OffertaTirocinio.aziendaOspitante}</span>
                            </a>
                        </li>
                    </ul>

                    <p class="fs-13 mb-10">${OffertaTirocinio.descrizioneBreve}</p>

                    <a href="/tirocinio?nome=20" class="btn btn-reveal btn-default b-0 btn-shadow-1">
                        <i class="fa fa-plus"></i>
                        <span>Leggi di pi&ugrave;</span>
                    </a>

                </div>
                </#list>

            <!-- /POST ITEMS -->
        </div>


            <h2 class="mb-0 mt-25">Ultime Convenzioni</h2>
            <div class="linea-divisione mt-15 mb-25"></div>
            <div id="blog" class="clearfix blog-isotope blog-isotope-2">
            <!-- POST ITEMS CONVENZIONI -->
                <#list LastFiveConvenzioni as LastFiveConvenzioni>
                <div class="blog-post-item radius-5 box-white border p-15">

                    <h4 class="mb-0"><a href="/SchedaAzienda?ID=${LastFiveConvenzioni.IDAzienda}" class="uppercase">${LastFiveConvenzioni.ragioneSociale}</a></h4>

                    <ul class="text-job list-inline mb-5">
                        <li class="pl-0">
                            <a>
                                <i class="fa fa-clock-o"></i>
                                <span class="font-lato">${LastFiveConvenzioni.dataConvenzione}</span>
                            </a>
                        </li>
                        <li>
                            <a href="/SchedaAzienda?ID=${LastFiveConvenzioni.IDAzienda}">
                                <i class="fa fa-industry"></i>
                                <span class="font-lato">${LastFiveConvenzioni.ragioneSociale}</span>
                            </a>
                        </li>
                    </ul>

                    <p class="fs-13 mb-10">${LastFiveConvenzioni.descrizione}</p>

                    <a href="/SchedaAzienda?ID=${LastFiveConvenzioni.IDAzienda}" class="btn btn-reveal btn-default b-0 btn-shadow-1">
                        <i class="fa fa-plus"></i>
                        <span>Leggi di pi&ugrave;</span>
                    </a>

                </div>
                </#list>
            <!-- POST ITEMS CONVENZIONI -->
        </div>
        </div>
    </section>
    <!-- /SECTION CENTER -->


    <#include "footer.ftl">
</div>
</body>
<#include "importScript.ftl">
</html>