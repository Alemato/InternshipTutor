<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Moduli disponibili</title>


    <#include "importCss.ftl">

    <!-- CSS DATATABLES -->
    <link href="../css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('../imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>MODULI</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li>Moduli Disponibili</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <h1 class="mb-0">MODULO PER LA CONVENZIONE</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <div class="table-responsive mb-30">
                <table class="table table-bordered g-white bg-white text-center border">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Tipologia</th>
                        <th>Data Convenzione</th>
                        <#if GiorniScadenza??>
                            <th>Gironi alla Scadenza</th>
                        </#if>
                        <th>Data Creazione</th>
                        <th>Data Aggiornamento</th>
                        <#if ConvenzioneScaduta>
                            <th>Aggiorna Convenzione</th>
                        <#else>
                            <th>Stampa Modulo</th>
                        </#if>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>CONVENZIONE PER LO SVOLGIMENTO DI ATTIVITA&apos; DI TIROCINIO E DI ORIENTAMENTO</td>
                        <td>CONVENZIONE</td>

                        <td>${DataConvenzione?date?string.short}</td>
                        <#if GiorniScadenza??>
                            <#if GiorniScadenza gt 1 >
                                <td>${GiorniScadenza} giorni</td>
                            <#else>
                                <td>${GiorniScadenza} giorno</td>
                            </#if>
                        </#if>
                        <td>${DataCreate?date?string.short}</td>
                        <td>${DataUpdate?date?string.short}</td>
                        <#if ConvenzioneScaduta>
                            <td><a href="/account/moduli/covenzione">
                                    <button type="button" class="btn btn-outline-danger"><i class="fa fa-file"></i>Aggiorna
                                        Modulo
                                    </button>
                                </a></td>
                        <#else>
                            <td><a href="/account/moduli/covenzione">
                                    <button type="button" class="btn btn-outline-success"><i class="fa fa-print"></i>Stampa
                                        Modulo
                                    </button>
                                </a></td>
                        </#if>

                    </tr>
                    </tbody>
                </table>
            </div>

            <h1 class="mb-0">MODULI TIROCINI SVOLTI</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <form id="form_tirocinii_fine" action="/account/moduli" method="post">
                <table class="table table-responsive table-striped table-bordered bg-white table-hover border"
                       id="datatable_2" width="100%"
                       cellspacing="0">
                    <thead>
                    <tr>
                        <th>Azienda Ospitante</th>
                        <th>Stato Richiesta</th>
                        <th>Numero Ore</th>
                        <th>Inizio Tirocinio</th>
                        <th>Fine Tirocinio</th>
                        <th>Tutore Aziendale</th>
                        <th>Tutore Universitario</th>
                        <th>Stampa Modulo</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Azienda Ospitante</th>
                        <th>Stato Richiesta</th>
                        <th>Numero Ore</th>
                        <th>Inizio Tirocinio</th>
                        <th>Fine Tirocinio</th>
                        <th>Tutore Aziendale</th>
                        <th>Tutore Universitario</th>
                        <th>Stampa Modulo</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <#list ritornaListaOff as ritornaListaOff>
                        <tr>
                            <td>${ritornaListaOff.aziendaOspitante}</td>
                            <#--TODO Stato del tirocinio-->
                            <#--<td>${ritornaListaOff.}</td>-->
                            <td>${ritornaListaOff.durataOra}</td>
                            <td>${ritornaListaOff.periodoInizio}</td>
                            <td>${ritornaListaOff.periodoFine}</td>
                            <td>${ritornaListaOff.nomeTutoreAziendale} ${ritornaListaOff.cognomeTutoreAziendale}</td>

                            <#--TODO Nome e Cognome Tutore Universitario-->
                            <#--<td>${ritornaListaOff.}</td>-->
                            <#--<td>${ritornaListaOff.}</td>-->
                            <td><a href="#">
                                    <button type="button" class="btn btn-outline-success"><i
                                                class="fa fa-print"></i>Stampa Modulo
                                    </button>
                                </a>
                        </tr>
                    </#list>
                    </tbody>
                </table>

                <footer class="text-center text-sm-right mt-25 ">
                    <button type="submit" form="form_tirocinii_fine"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                class="fa fa-check"></i> Aggiorna
                    </button>
                    <button type="reset" form="form_tirocinii_fine"
                            class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>

    </section>

    <#include "footer.ftl">
</div>

<#include "importScript.ftl">

<!-- Script page -->
<script src="../plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="../plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="../plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.js"></script>
<script src="../plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTableAccettati() {

        var table = jQuery('#datatable_2');

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
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }],
            "order": [
                [1, 'asc']
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Cerca: ",
                "searchPlaceholder": "Filtra i record",
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

    initTableAccettati();
</script>
</body>
</html>