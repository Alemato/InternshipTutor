<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

  <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="admin.html">HOME DASHBOARD</a></li>
        <li><a href="/gestione-utenti"><b>GESTIONE UTENZA</b></a></li>
        <li class="active"><a href="#"><b>GESTIONE: ${azienda.ragioneSociale}</b></a></li>
    </ol>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <div class="row">
                <a class="nav-link link-bar mt-5" href="#">Benvenuto, <b>ADMIN</b></a>
                <a class="nav-link link-bar text-center" href="#"><i class="fa fa-user-md fs-35 px-3"></i></a>
            </div>
        </li>
    </ul>

</nav>
<div class="container-fluid">
    <div class="row">
       <#include "../BackEndTemplates/sidebar.ftl">


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <div class="col">
                <form action="/modifica-azienda" method="post">
                    <input type="hidden" name="IDAzienda" value="${azienda.IDAzienda}">
                    <input type="hidden" name="IDUser" value="${user.IDUser}">
                    <#if WarningGenerico??>
                        <div class="alert alert-warning mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${WarningGenerico}
                        </div>
                    </#if>
                <div class="form-group">
                    <#if ErroreEmail??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreEmail}
                        </div>
                    </#if>
                    <label>Email</label>
                    <input type="email"  <#if ErroreEmail??> class="error" </#if> name="email" <#if ValueOfemail??> value="${ValueOfemail}" <#else> value="${user.email}</#if> ">
                </div>

                    <div class="form-group">
                        <#if ErroreRagioneSociale??>
                            <div class="alert alert-danger mb-20">
                                <button type="button" class="close" data-dismiss="alert">
                                    <span aria-hidden="true">&times;</span>
                                    <span class="sr-only">Chiudi</span>
                                </button>
                                <strong>Attenzione!</strong> ${ErroreRagioneSociale}
                            </div>
                        </#if>
                        <label>Nome Azienda</label>
                        <input type="text" <#if ErroreRagioneSociale??> class="error" </#if> name="ragionesociale"<#if ValueOfragioneSociale??> value="${ValueOfragioneSociale}" <#else> value="${azienda.ragioneSociale}" </#if> >
                    </div>

                <div class="form-group">
                    <#if ErroreIndirizzoSedeLegale??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreIndirizzoSedeLegale}
                        </div>
                    </#if>
                    <label>Indirizzo sede legale</label>
                    <input type="text"  <#if ErroreIndirizzoSedeLegale??> class="error" </#if> name="indirizzosedelegale" <#if ValueOfindirizzosedelegale??> value="${ValueOfindirizzosedelegale}" <#else> value="${azienda.indirizzoSedeLegale}" </#if> >
                </div>
                <div class="form-group">
                    <#if ErroreCFiscalePIva??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreCFiscalePIva}
                        </div>
                    </#if>
                    <label>Codice Fiscale O Partita Iva</label>
                    <input type="text" <#if ErroreCFiscalePIva??> class="error" </#if> name="cfiscalepiva" <#if ValueOfcfiscalepiva??> value="${ValueOfcfiscalepiva}" <#else> value="${azienda.CFiscalePIva}" </#if> >
                </div>
                <div class="row">
                    <#if ErroreNomeLegaleRappresentante??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreNomeLegaleRappresentante}
                        </div>
                    </#if>
                    <label>Nome Legale Rappresentante</label>
                    <input type="text" <#if ErroreNomeLegaleRappresentante??> class="error" </#if> name="nomelegalerappresentante" <#if ValueOfnomelegalerappresentante??> value="${ValueOfnomelegalerappresentante}" <#else> value="${azienda.nomeLegaleRappresentante}" </#if> >
                </div>
                <div class="row">
                    <#if ErroreCognomeLegaleRappresentante??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreCognomeLegaleRappresentante}
                        </div>
                    </#if>
                    <label>Cognome Legale Rappresentante</label>
                    <input type="text" <#if ErroreCognomeLegaleRappresentante??> class="error" </#if> name="cognomelegalerappresentante" <#if ValueOfcognomelegalerappresentante??> value="${ValueOfcognomelegalerappresentante}" <#else> value="${azienda.cognomeLegaleRappresentante}" </#if> >
                </div>
                <div class="row">
                    <#if ErroreNomeResponsabileConvenzione??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreNomeResponsabileConvenzione}
                        </div>
                    </#if>
                    <label>Nome Legale Convenzione</label>
                    <input type="text" <#if ErroreNomeResponsabileConvenzione??> class="error" </#if> name="nomeresponsabileconvenzione" <#if ValueOfnomeresponsabileconvenzione??> value="${ValueOfnomeresponsabileconvenzione}" <#else> value="${azienda.nomeResponsabileConvenzione}" </#if>  >
                </div>
                <div class="row">
                    <#if ErroreCognomeResponsabileConvenzione??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreCognomeResponsabileConvenzione}
                        </div>
                    </#if>
                    <label>Cognome Responsabile Convenzione</label>
                    <input type="text" <#if ErroreCognomeResponsabileConvenzione??> class="error" </#if> name="cognomeresponsabileconvenzione" <#if ValueOfcognomeresponsabileconvenzione??> value="${ValueOfcognomeresponsabileconvenzione}" <#else> value="${azienda.cognomeResponsabileConvenzione}" </#if> >
                </div>
                <div class="row">
                    <#if ErroreTelefonoResponsabileConvenzione??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreTelefonoResponsabileConvenzione}
                        </div>
                    </#if>
                    <label>Telefono Responsabile Convenzione</label>
                    <input type="text" <#if ErroreTelefonoResponsabileConvenzione??> class="error" </#if> name="telefonoresponsabileconvenzione"  <#if ValueOftelefonoresponsabileconvenzione??> value="${ValueOftelefonoresponsabileconvenzione}" <#else> value="${azienda.telefonoResponsabileConvenzione}" </#if> >
                </div>

                <div class="row">
                    <#if ErroreEmailResponsabileConvenzione??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreEmailResponsabileConvenzione}
                        </div>
                    </#if>
                    <label>Email Responsabile Convenzione</label>
                    <input type="text" <#if ErroreEmailResponsabileConvenzione??> class="error" </#if> name="emailresponsabileconvenzione" <#if ValueOfemailresponsabileconvenzione??> value="${ValueOfemailresponsabileconvenzione}" <#else> value="${azienda.emailResponsabileConvenzione}" </#if>  >
                </div>
                <div class="row">
                    <#if ErroreDurataConvenzione??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreDurataConvenzione}
                        </div>
                    </#if>
                    <label>Durata Convenzione</label>
                    <input type="number" <#if ErroreDurataConvenzione??> class="error" </#if> name="durataconvenzione"  <#if ValueOfdurataconvenzione??> value="${ValueOfdurataconvenzione}" <#else> value="${azienda.durataConvenzione}" </#if> >
                </div>
                <div class="row">
                    <#if ErroreForoControversia??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreForoControversia}
                        </div>
                    </#if>
                    <label>Foro Controversia</label>
                    <input type="text" <#if ErroreForoControversia??> class="error" </#if> name="forocontroversia"  <#if ValueOfforocontroversia??> value="${ValueOfforocontroversia}" <#else> value="${azienda.foroControversia}" </#if> >
                </div>
                <div class="row">
                    <#if ErroreDescrizione??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreDescrizione}
                        </div>
                    </#if>
                    <label>Descrizione </label>
                    <textarea inputmode=""   <#if ErroreDescrizione??> class="error" </#if> name="descrizione">  <#if ValueOfdescrizione??> ${ValueOfdescrizione}" <#elseif azienda.descizione?? > ${azienda.descrizione} </#if> </textarea>
                </div>

                <div class="row">
                    <#if ErroreLink??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreLink}
                        </div>
                    </#if>
                    <label>Link</label>
                    <input type="text" name="link"  <#if ErroreLink??> class="error" </#if> <#if ValueOflink??> value="${ValueOflink}" <#elseif azienda.link??> value="${azienda.link}" </#if> >
                </div>

                    <button type="submit" class="btn btn-primary" >Modifica</button>
                </form>

            </div>


        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->




</body>
</html>
