<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Moduli disponibili</title>
    <#include "importCss.ftl">
    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class=" enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>GESTIONE OFFERTE</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li>Gestione Offerte</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <h1 class="mb-0">OFFERTE DI TIROCINIO</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Visualizza Tutte le Offerte di Tirocinio
                </div>
                <div class="card-body">
                    <form id="form_gestione_offerte" class="" action="/account/gestione-offerte" method="post">
                        <table class="table table-striped table-bordered bg-white table-hover border"
                               id="datatable_1" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Codice Identificativo</th>
                                <th>Nome</th>
                                <th>Descrizione</th>
                                <th>Stato</th>
                                <th>Data Scadenza Prevista</th>
                                <th>Data Creazione</th>
                                <th>Data Aggiornamento</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Disattiva Offerta</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list listaOfferte as listaOfferte>
                                <tr>
                                    <td>${listaOfferte.codIdentTirocinio}</td>
                                    <td>${listaOfferte.titolo}</td>
                                    <td>${listaOfferte.descrizioneBreve}</td>
                                    <td>
                                        <#if listaOfferte.stato==1> Attivo <#else> Disattivato</#if></td>
                                    <td>${listaOfferte.periodoFine?date}</td>
                                    <td>${listaOfferte.createDate?date}</td>
                                    <td>${listaOfferte.updateDate?date}</td>
                                    <td><a href="/account/gestione-offerte?id=${listaOfferte.IDOffertaTirocinio}">
                                            <button type="button" class="btn btn-outline-success">Visualizza</button>
                                        </a></td>
                                    <td><a href="/account/gestione-offerte?id=${listaOfferte.IDOffertaTirocinio}">
                                            <button type="button" class="btn btn-outline-primary">Modifica</button>
                                        </a></td>
                                    <td><#if listaOfferte.stato==1>
                                            <input type="checkbox" class="checkboxes"
                                                   name="Disattiva_${listaOfferte.IDOffertaTirocinio}"/> Disattiva
                                        <#else>
                                            <input type="checkbox" class="checkboxes"
                                                   name="Disattiva_${listaOfferte.IDOffertaTirocinio}" checked
                                                   disabled/> Disattiva
                                        </#if>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                        <footer class="text-center text-sm-right mt-25 ">
                            <button type="submit" form="form_gestione_offerte"
                                    class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                        class="fa fa-check"></i> Aggiorna
                            </button>
                            <button type="reset" form="form_gestione_offerte"
                                    class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                        class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </form>
                </div>
            </div>


            <h1 class="mb-0">CREA UN OFFERTA</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <p>Per creare un offerta clicca su crea offerta
                <a class="col" href="/account/gestione-offerte/creazione-offerta">
                    <button type="button" class="btn btn-outline-primary"><i class="fa fa-pencil"></i> CREA OFFERTA
                    </button>
                </a>
            </p>
        </div>
    </section>
    <#include "footer.ftl">

</div>
<#include "importScript.ftl">

<!-- Script page -->
<script src="/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="/plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="/plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="/plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTableOfferte() {

        var table = jQuery('#datatable_1');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            },{
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
                [3, 'asc']
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
            "scrollX": true,
            "columnDefs": [  // set default column settings
                {"width": "150px", "targets": [2, 8]},
                {"width": "122px", "targets": [4, 5]},
                {
                    "searchable": true,
                    "targets": [0]
                }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    initTableOfferte();
</script>
</body>
</html>