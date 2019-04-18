<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Utenza</title>

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
        <li class="active"><a href="/gestione-aziende"><b>GESTIONE AZIENDA</b></a></li>
    </ol>
    <#include "small-navbar.ftl">

</nav>
<div class="container-fluid">
    <div class="row">
       <#include "sidebar.ftl">
<#--TODO controlla solo le barre e gli url con il filtro-->
        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>
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


            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2><i class="fa fa-industry fs-25"></i> Utenza di Tipo Aziendale</h2>
            <h3>Lista Aziende</h3>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Aziende
                </div>
                <div class="card-body">
                        <table class="table table-striped table-bordered table-hover" id="datatable_aziende" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Codice Fiscale - P.IVA </th>
                                <th>Nome Rappresentante</th>
                                <th>Cognome Rappresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Visualizza</th>
                                <th>Cambia Mail</th>
                                <th>Disattiva</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Codice Fiscale - P.IVA</th>
                                <th>Nome Rappresentante</th>
                                <th>Cognome Rappresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Visualizza</th>
                                <th>Cambia Mail</th>
                                <th>Disattiva</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#list aziende as azienda>
                            <tr>
                                <td>${azienda.ragioneSociale}</td>
                                <td>${azienda.CFiscalePIva}</td>
                                <td>${azienda.nomeLegaleRappresentante}</td>
                                <td>${azienda.cognomeLegaleRappresentante}</td>
                                <td>${azienda.nomeResponsabileConvenzione}</td>
                                <td>${azienda.cognomeResponsabileConvenzione}</td>
                                <td>${azienda.emailResponsabileConvenzione}</td>
                                <td>

                                        <a type="button" class="btn btn-success" href="/admin/show-azienda?IDAzienda=${azienda.IDAzienda}"><i class="fa fa-file-text"></i>Visualizza Utente</a>

                                </td>
                                <td>
                                  <a class="btn btn-secondary" href="/admin/reimposta-user?IDUser=${azienda.user}">
                                      <i class="fa fa-pencil-square-o"></i> Cambia </a>
                                </td>
                                <td>
                                    <#if azienda.attivo==1>
                                        <a type="button" class="btn btn-danger" href="/admin/disattiva-azienda?IDAzienda=${azienda.IDAzienda}"> Disattiva</a>
                                        <#else>
                                        <button class="btn btn-danger" disabled>Azienda Disattivata</button>
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

        </main>
    </div>
</div>


<#include "../importScript.ftl">

<!-- Script page -->
<script src="../../plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.js"></script>
<script src="../../plugins/select2/js/select2.full.min.js"></script>
<script>


    function initTableAziende() {

        var table = jQuery('#datatable_aziende');

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
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [0, 'asc'],
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
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


    initTableAziende();


</script>

</body>
</html>
