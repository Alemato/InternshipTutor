<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Internship Tutor</title>
    <#include "importCss.ftl">
</head>
<body class=" enable-animation">
<div id="wrapper">
    <#include "header.ftl">
    <img class="img-fluid mt-140" src="/imgs/internship.jpg">


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
                <#list LastFiveOfferta  as  OffertaTirocinio>
                <div class="blog-post-item radius-5 box-white border p-15">

                    <h2><a href="/tirocinio?ID=${OffertaTirocinio.IDOffertaTirocinio}" class="uppercase"> ${OffertaTirocinio.titolo}</a></h2>

                    <ul class="blog-post-info list-inline">
                        <li>
                                <i class="fa fa-clock-o"></i>

                            <#--il periodo di inizio-->

                                <span class="font-lato">${OffertaTirocinio.periodoInizio?string.short}</span>
                        </li>
                        <li>
                            <a href="schedaazienda?ID=${OffertaTirocinio.azienda}">
                                <i class="fa fa-industry"></i>
                                <span class="font-lato">${OffertaTirocinio.aziendaOspitante}</span>
                            </a>
                        </li>
                    </ul>

                    <p class="mb-10">${OffertaTirocinio.descrizioneBreve}</p>

                    <p>Per eventuali candidature o richieste di informazioni rivolgersi
                        a: ${OffertaTirocinio.emailTutoreAziendale}</p>
                       <p> <b class="mr-5"> Contatto aziendale:</b> ${OffertaTirocinio.nomeTutoreAziendale} ${OffertaTirocinio.cognomeTutoreAziendale}<a class="ml-25" href="mailto:${OffertaTirocinio.emailTutoreAziendale}">${OffertaTirocinio.emailTutoreAziendale}</a></p>
                    <a href="/tirocinio?ID=${OffertaTirocinio.IDOffertaTirocinio}" class="btn btn-reveal btn-default b-0 btn-shadow-1 mt-30">
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
                <#list LastFiveConvenzioni as Convenzioni>
                <div class="blog-post-item radius-5 box-white border p-15">
                    <h2 class="mb-0"><a href="/SchedaAzienda?ID=${Convenzioni.IDAzienda}" class="uppercase">${Convenzioni.ragioneSociale}</a></h2>

                    <ul class="blog-post-info list-inline">
                        <li class="pl-0">
                                <i class="fa fa-clock-o"></i>
                                <span class="font-lato">${Convenzioni.dataConvenzione?string.short}</span>
                        </li>
                        <li>
                            <a href="/SchedaAzienda?ID=${Convenzioni.IDAzienda}">
                                <i class="fa fa-industry"></i>
                                <span class="font-lato">${Convenzioni.ragioneSociale}</span>
                            </a>
                        </li>
                    </ul>

                    <p class="mb-10"><#if Convenzioni.descrizione??><#if Convenzioni.descrizione?has_content>${Convenzioni.descrizione} <#else> Descrizione Azienda non disponibile</#if> <#else> Descrizione Azienda non disponibile</#if></p>

                    <a href="/SchedaAzienda?ID=${Convenzioni.IDAzienda}" class="btn btn-reveal btn-default b-0 btn-shadow-1 mt-30">
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