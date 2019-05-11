<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Moduli</title>
    <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="enable-animation">

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="/home">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href="/admin/dashboard">HOME DASHBOARD</a></li>
        <li class="active"><a href="/admin/gestione-tirocinio"><b>GESTIONE MODULI</b></a></li>
    </ol>
    <#include "small-navbar.ftl">

</nav>
<div class="container-fluid">
    <div class="row">
        <#include "sidebar.ftl">

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto
                        <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>
            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2><i class="fa fa-archive"></i> Gestione Moduli Tirocini</h2>
            <#if WarningSuccess??>
                <div class="alert alert-success mb-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione!</strong> ${WarningSuccess}
                </div>
            </#if>
            <#if WarningInsuccess??>
                <div class="alert alert-danger mb-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione!</strong> ${WarningInsuccess}
                </div>
            </#if>

            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Moduli di Richiesta Tirocinio dei Tirocinanti
                </div>
                <div class="card-body">
                    <table class="table table-responsive table-striped table-bordered table-hover"
                           id="datatable_ric_tiro" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>Codice Fiscale Tirocinante</th>
                            <th>Ente/Azienda Ospitante</th>
                            <th>Sede Legale Ente</th>
                            <th>Codice Fiscale Ente</th>
                            <th>Nome Tutore Aziendale</th>
                            <th>Cognome Tutore Aziendale</th>
                            <th>Tel. Tutore Aziendale</th>
                            <th>Nome Tutore Univeresitario</th>
                            <th>Cognome Tutore Univeresitario</th>
                            <th>Tel. Tutore Univeresitario</th>
                            <th>Data Richiesta</th>

                            <th>Visualizza Richiesta</th>
                            <th>Visualizza PDF Caricato</th>
                            <th>Invalida PDF</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>Codice Fiscale Tirocinante</th>
                            <th>Ente/Azienda Ospitante</th>
                            <th>Sede Legale Ente</th>
                            <th>Codice Fiscale Ente</th>
                            <th>Nome Tutore Aziendale</th>
                            <th>Cognome Tutore Aziendale</th>
                            <th>Tel. Tutore Aziendale</th>
                            <th>Nome Tutore Univeresitario</th>
                            <th>Cognome Tutore Univeresitario</th>
                            <th>Tel. Tutore Univeresitario</th>
                            <th>Data Richiesta</th>

                            <th>Visualizza Richiesta</th>
                            <th>Visualizza PDF Caricato</th>
                            <th>Invalida PDF</th>

                        </tr>
                        </tfoot>
                        <tbody>
                        <#list Richieste as tirocinio,dati>
                            <tr>
                                <td>${dati[0]}</td>
                                <td>${dati[1]}</td>
                                <td>${dati[2]}</td>
                                <td>${dati[3]}</td>
                                <td>${dati[4]}</td>
                                <td>${dati[5]}</td>
                                <td>${dati[6]}</td>
                                <td>${dati[7]}</td>
                                <td>${dati[8]}</td>
                                <td>${dati[9]}</td>
                                <td>${dati[10]}</td>
                                <td>${dati[11]}</td>
                                <td>${tirocinio.createDate?date?string("dd-MM-yyyy")}</td>
                                <td>
                                    <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button"
                                           href="/admin/modulo-richista?IDTirocinio=${tirocinio.IDTirocinio}"
                                           class="btn btn-primary"> <i class="fa fa-file-text"></i> Visualizza</a>
                                    <#else>
                                        <button class="btn btn-primary" disabled><i class="fa fa-file-text"></i> Non disponibile
                                        </button>
                                    </#if>
                                </td>
                                <td>
                                    <#--TODO Metti i link non appena pronti-->
                                    <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button" href="/admin/modulo/richiesta-tirocinio?id=${tirocinio.IDTirocinio}" class="btn btn-secondary" > Visualizza PDF </a>
                                    <#else>
                                        <button type="button" class="btn btn-secondary" disabled><i
                                                    class="fa fa-file-pdf-o"></i> PDF Non Presente
                                        </button>
                                    </#if>

                                </td>
                                <td>
                                    <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button"
                                           href="/admin/invalida-pdf-Tirocinante=IDTirocinio=${tirocinio.IDTirocinio}"
                                           class="btn btn-danger"> <i class="fa fa-file-pdf-o"></i> Invalida PDF</a>
                                    <#else>
                                        <button class="btn btn-danger" disabled><i class="fa fa-file-pdf-o"></i>
                                            Azione non disponibile
                                        </button>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <footer class="text-center text-sm-right mt-25 ">
                    </footer>
                </div>
            </div>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2> <i class="fa fa-archive"></i>Tirocinii Conclusi</h2>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Moduli per Conclusione Tirocinii
                </div>
                <div class="card-body">
                    <table class="table table-responsive table-striped table-bordered table-hover"
                           id="datatable_fine_tirocinio" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>Codice Fiscale Tirocinante</th>
                            <th>Ente/Azienda Ospitante</th>
                            <th>Sede Legale Ente</th>
                            <th>Codice Fiscale Ente</th>
                            <th>Nome Tutore Aziendale</th>
                            <th>Cognome Tutore Aziendale</th>
                            <th>Tel. Tutore Aziendale</th>
                            <th>Nome Tutore Univeresitario</th>
                            <th>Cognome Tutore Univeresitario</th>
                            <th>Tel. Tutore Univeresitario</th>
                            <th>Data Richiesta</th>

                            <th>Visualizza Modulo Richiesta Tirocinio (Tirocinante)</th>
                            <th>Visualizza PDF Caricato (Tirocinante)</th>
                            <th>Invalida PDF Caricato (Tirocinante)</th>

                            <th>Visualizza Modulo Conclusione Tirocinio (Azienda)</th>
                            <th>Visualizza PDF Caricato (Azienda)</th>
                            <th>Invalida PDF (Azienda)</th>

                            <th>Visualizza Modulo Conclusione Tirocinio (Segreteria)</th>
                            <th>Visualizza PDF Caricato (Segreteria)</th>
                            <th>Crea/Modifica PDF (Segreteria)</th>
                            <th>Carica/Ricarica PDF</th>


                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>Codice Fiscale Tirocinante</th>
                            <th>Ente/Azienda Ospitante</th>
                            <th>Sede Legale Ente</th>
                            <th>Codice Fiscale Ente</th>
                            <th>Nome Tutore Aziendale</th>
                            <th>Cognome Tutore Aziendale</th>
                            <th>Tel. Tutore Aziendale</th>
                            <th>Nome Tutore Univeresitario</th>
                            <th>Cognome Tutore Univeresitario</th>
                            <th>Tel. Tutore Univeresitario</th>
                            <th>Data Richiesta</th>

                            <th>Visualizza Modulo Richiesta Tirocinio (Tirocinante)</th>
                            <th>Visualizza PDF Caricato (Tirocinante)</th>
                            <th>Invalida PDF Caricato (Tirocinante)</th>

                            <th>Visualizza Modulo Conclusione Tirocinio (Azienda)</th>
                            <th>Visualizza PDF Caricato (Azienda)</th>
                            <th>Invalida PDF (Azienda)</th>

                            <th>Visualizza Modulo Conclusione Tirocinio (Segreteria)</th>
                            <th>Visualizza PDF Caricato (Segreteria)</th>
                            <th>Crea/Modifica PDF (Segreteria)</th>
                            <th>Carica/Ricarica PDF</th>

                        </tr>
                        </tfoot>
                        <tbody>
                        <#if TirociniConclusi?has_content>
                            <#list TirociniConclusi as tirocinio,dati >
                                <tr>
                                    <td>${dati[0]}</td>
                                    <td>${dati[1]}</td>
                                    <td>${dati[2]}</td>
                                    <td>${dati[3]}</td>
                                    <td>${dati[4]}</td>
                                    <td>${dati[5]}</td>
                                    <td>${dati[6]}</td>
                                    <td>${dati[7]}</td>
                                    <td>${dati[8]}</td>
                                    <td>${dati[9]}</td>
                                    <td>${dati[10]}</td>
                                    <td>${dati[11]}</td>
                                    <td>${tirocinio.createDate?date?string("dd-MM-yyyy")}</td>

                                    <td>
                                        <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button" class="btn btn-success"
                                           href="/admin/modulo-richista?IDTirocinio=${tirocinio.IDTirocinio}"><i
                                                    class="fa fa-file-text"></i>Visualizza</a>
                                            <#else>
                                                <a type="button" class="btn btn-success"
                                                   disabled><i class="fa fa-file-text"></i>Modulo non presente</a>

                                        </#if>
                                    </td>
                                    <td>
                                        <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button" class="btn btn-secondary" href="/admin/modulo/richiesta-tirocinio?id=${tirocinio.IDTirocinio}"> <i
                                                    class="fa fa-file-pdf-o"></i>Visualizza PDF</a>
                                        <#else>
                                         <a type="button" class="btn btn-secondary"
                                                   disabled><i
                                                    class="fa fa-file-pdf-o"></i>PDF non presente</a>
                                        </#if>
                                    </td>

                                    <td>
                                        <#if (tirocinio.pdfTirocinante)??>
                                            <a type="button" href="/admin/invalida-pdf-Tirocinante?IDTirocinio=${tirocinio.IDTirocinio}" class="btn btn-danger"><i
                                                        class="fa fa-file-text"></i>Invalida</a>
                                        <#else>
                                            <button type="button" class="btn btn-danger" disabled><i
                                                        class="fa fa-file-text"></i>Azione non disponibile
                                            </button>
                                        </#if>
                                    </td>

                                    <td>
                                        <#if (tirocinio.pdfAzienda)??>
                                            <a type="button" class="btn btn-success"
                                               href="/admin/modulo-azienda?IDTirocinio=${tirocinio.IDTirocinio}"> <i
                                                        class="fa fa-file-text"> </i>Visualizza</a>
                                        <#else>
                                            <button type="button" class="btn btn-success" disabled><i
                                                        class="fa fa-file-text"> </i>Non Disponibile
                                            </button>
                                        </#if>
                                    </td>
                                    <td>
                                        <#if (tirocinio.pdfAzienda)??>
                                            <a type="button" class="btn btn-secondary" href="/admin/modulo/tirocinio?id=${tirocinio.IDTirocinio}"> <i
                                                        class="fa fa-file-pdf-o"> </i>Visualizza PDF</a>
                                        <#else>
                                            <button type="button" class="btn btn-secondary" disabled><i
                                                        class="fa fa-file-pdf-o"> </i>PDF Non Disponibile
                                            </button>
                                        </#if>

                                    </td>
                                    <td>
                                        <#if (tirocinio.pdfAzienda)??>
                                            <a type="button" href="/admin/invalida-pdf-azienda?IDTirocinio=${tirocinio.IDTirocinio}" class="btn btn-danger"><i
                                                        class="fa fa-file-text"></i>Invalida</a>
                                        <#else>
                                            <button type="button" class="btn btn-danger" disabled><i
                                                        class="fa fa-file-text"></i>Azione non disponibile
                                            </button>
                                        </#if>

                                    </td>
                                    <td>
                                        <#if (tirocinio.pdfSegreteria)??>
                                            <a type="button" class="btn btn-success"
                                               href="/admin/modulo-segreteria?IDTirocinio=${tirocinio.IDTirocinio}"><i
                                                        class="fa fa-file-text"></i>Visualizza</a>
                                        <#else>
                                            <button type="button" class="btn btn-success" disabled><i
                                                        class="fa fa-file-text"></i> Azione non disponibile
                                            </button>
                                        </#if>


                                    </td>
                                    <td>
                                        <#if (tirocinio.pdfSegreteria)??>
                                            <a type="button" class="btn btn-secondary" href="/admin/modulo/segreteria?id=${tirocinio.IDTirocinio}"> <i
                                                        class="fa fa-file-pdf-o"> </i>Visualizza PDF</a>
                                        <#else>
                                            <button type="button" class="btn btn-secondary" disabled><i
                                                        class="fa fa-file-pdf-o"> </i>PDF Non Disponibile
                                            </button>
                                        </#if>

                                    </td>
                                    <td>
                                        <#if (tirocinio.pdfSegreteria)??>
                                            <button class="btn btn-secondary" href="/#" disabled> Azione non
                                                disponibile
                                            </button>
                                        <#else>

                                            <a type="button" class="btn btn-secondary" href="/admin/crea-modulosegreteria?IDTirocinio=${tirocinio.IDTirocinio}"> <i class="fa fa-file-pdf-o"> </i>Crea/Modifica PDF </a>

                                        </#if>
                                    </td>
                                    <td>
                                        <#--TODO metti a posto il pulsante-->
                                        <#if tirocinio.pdfSegreteria?has_content>
                                            <a type="button" href="/#" class="btn btn-primary" disabled> Azione non
                                                disponibile</a>
                                        <#else>
                                            <form enctype="multipart/form-data" class="mb-2" method="POST"
                                                  action="/admin/salva-segreteria?ID=${tirocinio.IDTirocinio}">
                                                <div class="col">
                                                    <input type="file" name="PDF">
                                                    <button type="submit"  class="btn btn-success ml-4 mt-7"> Invia</button>
                                                </div>
                                            </form>
                                        </#if>
                                    </td>
                                </tr>
                            </#list>

                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>
            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2><i class="fa fa-archive"></i>Tirocinii Attivi</h2>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Moduli di Tirocinio Attive
                </div>
                <div class="card-body">
                    <table class="table table-responsive table-striped table-bordered table-hover"
                           id="datatable_tr_attivi" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>Codice Fiscale Tirocinante</th>
                            <th>Ente/Azienda Ospitante</th>
                            <th>Sede Legale Ente</th>
                            <th>Codice Fiscale Ente</th>
                            <th>Nome Tutore Aziendale</th>
                            <th>Cognome Tutore Aziendale</th>
                            <th>Tel. Tutore Aziendale</th>
                            <th>Nome Tutore Univeresitario</th>
                            <th>Cognome Tutore Univeresitario</th>
                            <th>Tel. Tutore Univeresitario</th>
                            <th>Data Richiesta</th>
                            <th>Visualizza Richiesta</th>
                            <th>Visualizza PDF Caricato</th>
                            <th>Invalida PDF</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>Codice Fiscale Tirocinante</th>
                            <th>Ente/Azienda Ospitante</th>
                            <th>Sede Legale Ente</th>
                            <th>Codice Fiscale Ente</th>
                            <th>Nome Tutore Aziendale</th>
                            <th>Cognome Tutore Aziendale</th>
                            <th>Tel. Tutore Aziendale</th>
                            <th>Nome Tutore Univeresitario</th>
                            <th>Cognome Tutore Univeresitario</th>
                            <th>Tel. Tutore Univeresitario</th>
                            <th>Data Richiesta</th>
                            <th>Visualizza Richiesta</th>
                            <th>Visualizza PDF Caricato</th>
                            <th>Invalida PDF</th>

                        </tr>
                        </tfoot>
                        <tbody>


                        <#list Attive as tirocinio,dati>
                            <tr>
                                <td>${dati[0]}</td>
                                <td>${dati[1]}</td>
                                <td>${dati[2]}</td>
                                <td>${dati[3]}</td>
                                <td>${dati[4]}</td>
                                <td>${dati[5]}</td>
                                <td>${dati[6]}</td>
                                <td>${dati[7]}</td>
                                <td>${dati[8]}</td>
                                <td>${dati[9]}</td>
                                <td>${dati[10]}</td>
                                <td>${dati[11]}</td>
                                <td>${tirocinio.createDate?date?string("dd-MM-yyyy")}</td>
                                <td>
                                    <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button"
                                           href="/admin/modulo-richista?IDTirocinio=${tirocinio.IDTirocinio}"
                                           class="btn btn-danger"> Visualizza Modulo Richiesta</a>
                                    <#else>
                                        <button class="btn btn-danger" disabled><i class="fa fa-file-pdf-o"></i> Non
                                            disponibile
                                        </button>
                                    </#if>
                                </td>
                                <td>
                                    <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button" href="/admin/modulo/richiesta-tirocinio?id=${tirocinio.IDTirocinio}" class="btn btn-danger"> <i
                                                    class="fa fa-file-pdf-o"></i> Visualizza PDF</a>
                                    <#else>
                                        <button class="btn btn-danger" disabled><i class="fa fa-file-pdf-o"></i> Non
                                            disponibile
                                        </button>
                                    </#if>
                                </td>
                                <td>
                                    <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button"
                                           href="/admin/invalida-pdf-Tirocinante?IDTirocinio=${tirocinio.IDTirocinio}"
                                           class="btn btn-danger"> <i class="fa fa-file-pdf-o"></i> Invalida PDF</a>
                                    <#else>
                                        <button class="btn btn-danger" disabled><i class="fa fa-file-pdf-o"></i> Non
                                            disponibile
                                        </button>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2><i class="fa fa-archive"></i>Tirocinii Rifiutati</h2>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Moduli di Richiesta Tirocinio Rifiutati
                </div>
                <div class="card-body">
                    <table class="table table-responsive table-striped table-bordered table-hover" id="datatable_ric_tiro_rif" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>Codice Fiscale Tirocinante</th>
                            <th>Ente/Azienda Ospitante</th>
                            <th>Sede Legale Ente</th>
                            <th>Codice Fiscale Ente</th>
                            <th>Nome Tutore Aziendale</th>
                            <th>Cognome Tutore Aziendale</th>
                            <th>Tel. Tutore Aziendale</th>
                            <th>Nome Tutore Univeresitario</th>
                            <th>Cognome Tutore Univeresitario</th>
                            <th>Tel. Tutore Univeresitario</th>
                            <th>Data Richiesta</th>
                            <th>Visualizza Richiesta</th>
                            <th>Visualizza PDF Caricato</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>Codice Fiscale Tirocinante</th>
                            <th>Ente/Azienda Ospitante</th>
                            <th>Sede Legale Ente</th>
                            <th>Codice Fiscale Ente</th>
                            <th>Nome Tutore Aziendale</th>
                            <th>Cognome Tutore Aziendale</th>
                            <th>Tel. Tutore Aziendale</th>
                            <th>Nome Tutore Univeresitario</th>
                            <th>Cognome Tutore Univeresitario</th>
                            <th>Tel. Tutore Univeresitario</th>
                            <th>Data Richiesta</th>
                            <th>Visualizza Richiesta</th>
                            <th>Visualizza PDF Caricato</th>

                        </tr>
                        </tfoot>
                        <tbody>


                        <#list Rifiutati as tirocinio,dati>
                            <tr>
                                <td>${dati[0]}</td>
                                <td>${dati[1]}</td>
                                <td>${dati[2]}</td>
                                <td>${dati[3]}</td>
                                <td>${dati[4]}</td>
                                <td>${dati[5]}</td>
                                <td>${dati[6]}</td>
                                <td>${dati[7]}</td>
                                <td>${dati[8]}</td>
                                <td>${dati[9]}</td>
                                <td>${dati[10]}</td>
                                <td>${dati[11]}</td>
                                <td>${tirocinio.createDate?date?string("dd-MM-yyyy")}</td>
                                <td>
                                    <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button"
                                           href="/admin/modulo-richista?IDTirocinio=${tirocinio.IDTirocinio}"
                                           class="btn btn-danger"> Visualizza Modulo Richiesta</a>
                                    <#else>
                                        <button class="btn btn-danger" disabled><i class="fa fa-file-pdf-o"></i> Non
                                            disponibile
                                        </button>
                                    </#if>
                                </td>
                                <td>
                                    <#if (tirocinio.pdfTirocinante)??>
                                        <a type="button" href="/admin/modulo/richiesta-tirocinio?id=${tirocinio.IDTirocinio}" class="btn btn-danger"> <i
                                                    class="fa fa-file-pdf-o"></i> Visualizza PDF</a>
                                    <#else>
                                        <button class="btn btn-danger" disabled><i class="fa fa-file-pdf-o"></i> Non
                                            disponibile
                                        </button>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">


<!-- Script page -->
<script src="../../plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.js"></script>
<script src="../../plugins/select2/js/select2.full.min.js"></script>
<script>

    function initTableFineTirocinio() {

        var table = jQuery('#datatable_fine_tirocinio');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc']
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableRifiutati() {

        var table = jQuery('#datatable_ric_tiro_rif');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc']
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }]
        });
        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableAttive() {

        var table = jQuery('#datatable_tr_attivi');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc']
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }]
        });
        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableRicTiro() {

        var table = jQuery('#datatable_ric_tiro');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc']
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }


    initTableRicTiro();
    initTableFineTirocinio();
    initTableAttive();
    initTableRifiutati();

</script>
</body>
</html>
