<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Richieste Convenzioni</title>

    <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

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
        <li class="active"><a href="gestione-utenza-admin.html"><b>GESTIONE RICHIESTE CONVENZIONE</b></a></li>
    </ol>
    <#include "small-navbar.ftl">

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
            <h2>Richieste di Convenzioni Aziendali Pendenti</h2>

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

            <h3>Lista Richieste</h3>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Richieste di Convenzionamento pendenti
                </div>
                <div class="card-body">
                    <div class="table-responsive">

                        <table class="table table-striped table-bordered table-hover" id="datatable_richieste" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Sede Legale</th>
                                <th>Codice Fiscale</th>
                                <th>Nome Rapresentante</th>
                                <th>Cognome Rapresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Tel. Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Richiesta</th>
                                <th>Visualizza PDF</th>
                                <th>Accetta Richiesta </th>
                                <th>Declina richiesta</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Sede Legale</th>
                                <th>Codice Fiscale</th>
                                <th>Nome Rapresentante</th>
                                <th>Cognome Rapresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Tel. Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Data Richiesta</th>
                                <th>Modulo Richiesta</th>
                                <th>Visualizza PDF</th>
                                <th>Accetta Richiesta </th>
                                <th>Declina richiesta</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#if AziendaPendenti?has_content>
                            <#list AziendaPendenti as azienda>
                                <tr>

                                    <td>${azienda.ragioneSociale}</td>
                                    <td>${azienda.indirizzoSedeLegale}</td>
                                    <td>${azienda.CFiscalePIva}</td>
                                    <td>${azienda.nomeLegaleRappresentante}</td>
                                    <td>${azienda.cognomeLegaleRappresentante}</td>
                                    <td>${azienda.nomeResponsabileConvenzione}</td>
                                    <td>${azienda.cognomeResponsabileConvenzione}</td>
                                    <td>${azienda.telefonoResponsabileConvenzione}</td>
                                    <td>${azienda.emailResponsabileConvenzione}</td>

                                    <td> <#if azienda.pathPDFConvenzione?has_content > ${azienda.dataConvenzione?date?string("yyyy-MM-dd")}
                                        <#else> convenzione non ancora richiesta </#if></td>
                                    <td>
                                        <#if (azienda.pathPDFConvenzione)??> <a type="button" href="/#" class="btn btn-primary"> Visualizza</a>
                                        <#else>
                                            <button type="button" class="btn btn-primary" disabled> Non  presente</button>
                                        </#if>

                                    </td>
                                    <td>
                                        <#if (azienda.pathPDFConvenzione)??>     <a type="button" href="/#" class="btn btn-secondary"> Visualizza PDF</a>
                                        <#else>
                                            <button type="button" class="btn btn-primary" disabled> PDF non presente</button>
                                        </#if>

                                    </td>
                                    <td>
                                        <a  type="button" class="btn btn-success" href="/Accetta?IDAzienda=${azienda.IDAzienda}&stato=accetta">Accetta</a>
                                    </td>
                                    <td>
                                        <a  type="button" class="btn btn-danger" href="/Accetta?IDAzienda=${azienda.IDAzienda}&stato=declina">Declina</a>
                                    </td>
                                </tr>
                            </#list>
                            </#if>

                            </tbody>
                        </table>

                        <footer class="text-center text-sm-right mt-25 ">
                        </footer>
                    </div>
                </div>
            </div>




        </main>
    </div>
</div>


<#include "../importScript.ftl">

<!-- Script page -->
<script src="/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="/plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="/plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="/plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTableRichieste() {

        var table = jQuery('#datatable_richieste');

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
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [9, 'desc'],
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
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }
    initTableRichieste();



</script>
</body>
</html>
