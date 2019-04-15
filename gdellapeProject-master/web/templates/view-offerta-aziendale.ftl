<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>${titoloOfferta}</title>
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

            <h1>${titoloOfferta}</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li>Gestione Offerte</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section">
        <div class="container p-0">
            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Descrizione :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro"><p>${Descrizione}</p></h4>
                </div>
            </div>
            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Descrizione Breve :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro"><p>${DescrizioneBreve}</p></h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Luogo di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${LuogoEffettuazione}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Orari di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${Orario}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Durata del tirocinio :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        Dal ${PeriodoInizio?date} al ${PeriodoFine?date}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Obiettivi del tirocinio:</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${Obbiettivi}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Modalit&agrave; di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${Modalita}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Rimborsi spese e facilitzioni previste :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        <#if Rimbosi??>${Rimbosi}<#else>Nessun tipo di rimborso.</#if><#if Facilitazioni??> ${Facilitazioni}<#else>Nessun tipo di facilitazione prevista.</#if>
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Nome e Cognome del Responsabile aziendale:</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${NomeRespAz} ${CognomeRepAz}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Email del responsabile aziendale :</h4>
                </div>
                <div class="row col-12 col-md-5 col-lg-6 mb-sm-5 mb-0">
                    <i class="fa fa-send fs-19 pl-15 pt-4 mr-10"></i>
                    <h4 class="testo-scuro">
                        <a href="mailto:mario.rossi@aveja.it">${EmailRespAZ}</a>
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">telefono responsabile Aziendale :</h4>
                </div>
                <div class="row col-12 col-md-5 col-lg-6 mb-sm-5 mb-0">
                    <i class="fa fa-phone-square fs-19 pl-15 pt-4 mr-10"></i><h4 class="testo-scuro letter-spacing-1">
                        ${TelRespAz}
                    </h4>
                </div>
            </div>

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <h1 class="mb-0">Tirocinanti</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Visualizza Tutti i Tirocinanti Attivi
                </div>
                <div class="card-body">
                    <form id="form_tirocinii_fine" action="/account/moduli" method="post">
                    <table class="table table-striped table-bordered bg-white table-hover border"
                           id="datatable_1" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>email Tirocinante</th>
                            <th>Stato</th>
                            <th>Richiesta Fine Tirocinio</th>
                            <th>Modulo Richiesta</th>
                            <th>Modulo Fine Tirocinio</th>
                            <th>Modulo Segreteria</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list Lista as Lista>
                        <tr>
                            <td>${Lista.tirocinante.nome}</td>
                            <td>${Lista.tirocinante.cognome}</td>
                            <td>${Lista.userMail}</td>
                            <#if Lista.tirocinio.stato == 0>
                                <td>Richiesta Inviata</td>
                                <td><input type="checkbox" class="checkboxes"
                                           name="fin_${Lista.tirocinante.nome}-${Lista.tirocinante.cognome}-${Lista.tirocinante.IDTirocinante}-${Lista.tirocinio.IDTirocinio}"
                                           value="1" disabled="disabled"/> <i
                                            class="fa fa-check" style="color: green;"></i> Tirocinio finito
                                </td>
                                <#if Lista.tirocinio.pdfTirocinante??>
                                    <td><a href="/account/moduli/richiesta-tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa PDF
                                            </button>
                                        </a>
                                    </td>
                                <#else>
                                    <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                    </td>
                                </#if>
                                <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                </td>
                                <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                </td>
                            <#elseif Lista.tirocinio.stato == 1>
                                <td>Tirocinio in corso</td>
                                <td><input type="checkbox" class="checkboxes"
                                           name="fin_${Lista.tirocinante.nome}-${Lista.tirocinante.cognome}-${Lista.tirocinante.IDTirocinante}-${Lista.tirocinio.IDTirocinio}"
                                           value="1" /> <i
                                            class="fa fa-check" style="color: green;"></i> Tirocinio finito
                                </td>
                                <td><a href="/account/moduli/richiesta-tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa PDF
                                            </button>
                                        </a>
                                </td>
                                <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                </td>
                                <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                </td>
                            <#elseif Lista.tirocinio.stato == 2>
                                <td>Tirocinio Concluso</td>
                                <td><input type="checkbox" class="checkboxes"
                                           name="fin_${Lista.tirocinante.nome}-${Lista.tirocinante.cognome}-${Lista.tirocinante.IDTirocinante}-${Lista.tirocinio.IDTirocinio}"
                                           value="1" checked
                                           disabled/> <i
                                            class="fa fa-check" style="color: green;"></i> Tirocinio finito
                                </td>
                                <td><a href="/account/moduli/richiesta-tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                        <button type="button" class="btn btn-outline-success"><i
                                                    class="fa fa-print"></i>Stampa PDF
                                        </button>
                                    </a>
                                </td>
                                <#if Lista.tirocinio.pdfAzienda??>
                                    <td><a href="/account/moduli/crea-fine-tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa PDF
                                            </button>
                                        </a>
                                    </td>
                                <#else>
                                    <td><a href="/account/moduli/tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa Modulo
                                            </button>
                                        </a>
                                    </td>
                                </#if>
                                <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                </td>
                            <#elseif Lista.tirocinio.stato == 3>
                                <td>Tirocinio Concluso</td>
                                <td><input type="checkbox" class="checkboxes"
                                           name="fin_${Lista.tirocinante.nome}-${Lista.tirocinante.cognome}-${Lista.tirocinante.IDTirocinante}-${Lista.tirocinio.IDTirocinio}"
                                           value="1" checked
                                           disabled/> <i
                                            class="fa fa-check" style="color: green;"></i> Tirocinio finito
                                </td>
                                <td><a href="/account/moduli/richiesta-tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                        <button type="button" class="btn btn-outline-success"><i
                                                    class="fa fa-print"></i>Stampa PDF
                                        </button>
                                    </a>
                                </td>
                                <td><a href="/account/moduli/tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                        <button type="button" class="btn btn-outline-success"><i
                                                    class="fa fa-print"></i>Stampa PDF
                                        </button>
                                    </a>
                                </td>
                                <#if Lista.tirocinio.pdfSegreteria??>
                                    <td><a href="/account/moduli/segreteria?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa PDF
                                            </button>
                                        </a>
                                    </td>
                                <#else>
                                    <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                    </td>
                                </#if>
                            <#elseif Lista.tirocinio.stato == 4>
                                <td>Tirocinio Concluso</td>
                                <td><input type="checkbox" class="checkboxes"
                                           name="fin_${Lista.tirocinante.nome}-${Lista.tirocinante.cognome}-${Lista.tirocinante.IDTirocinante}-${Lista.tirocinio.IDTirocinio}"
                                           value="1" checked
                                           disabled/> <i
                                            class="fa fa-check" style="color: green;"></i> Tirocinio finito
                                </td>
                                <td><a href="/account/moduli/richiesta-tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                        <button type="button" class="btn btn-outline-success"><i
                                                    class="fa fa-print"></i>Stampa PDF
                                        </button>
                                    </a>
                                </td>
                                <td><a href="/account/moduli/tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                        <button type="button" class="btn btn-outline-success"><i
                                                    class="fa fa-print"></i>Stampa PDF
                                        </button>
                                    </a>
                                </td>

                                <td><a href="/account/moduli/segreteria?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa PDF
                                            </button>
                                        </a>
                                </td>
                            <#elseif Lista.tirocinio.stato == 5>
                                <td>Richiesta rifiutata</td>
                                <td><input type="checkbox" class="checkboxes"
                                           name="fin_${Lista.tirocinante.nome}-${Lista.tirocinante.cognome}-${Lista.tirocinante.IDTirocinante}-${Lista.tirocinio.IDTirocinio}"
                                           value="1" checked disabled="disabled"/> <i
                                            class="fa fa-check" style="color: green;"></i> Tirocinio finito
                                </td>
                                <#if Lista.tirocinio.pdfTirocinante??>
                                    <td><a href="/account/moduli/richiesta-tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa PDF
                                            </button>
                                        </a>
                                    </td>
                                <#else>
                                    <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                    </td>
                                </#if>
                                <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                </td>
                                <td><button type="button" class="btn btn-outline-danger"><i
                                                    class="fa fa-print"></i>Modulo non disponibile
                                        </button>
                                </td>
                            </#if>
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
                </div>
            </div>
            <#if Scaduto??>
                <#if !Scaduto>
            <h1 class="mb-0">Richieste Pendanti</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Visualizza Tutte le Richieste di Tirocinio pendenti
                </div>
                <div class="card-body">
                    <form id="form_tirocinii_fine" action="/account/gestione-richieste" method="post">
                        <table class="table table-striped table-bordered bg-white table-hover border"
                               id="datatable_2" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Tirocinante</th>
                                <th>Cognome Tirocinante</th>
                                <th>email Tirocinante</th>
                                <th>Accetta Richiesta</th>
                                <th>Rifiuta Richiesta</th>
                            </tr>
                            </thead>
                            <tbody id="checkbox">
                            <#list Lista as Lista1>
                                <#if Lista1.tirocinio.stato == 0>
                                <tr>
                                    <td>${Lista1.tirocinante.nome}</td>
                                    <td>${Lista1.tirocinante.cognome}</td>
                                    <td>${Lista1.userMail}</td>
                                    <td><input type="checkbox" class="checkboxes" name="ac-${Lista1.tirocinante.IDTirocinante}-${Lista1.tirocinio.IDTirocinio}" value="1"/> <i
                                                class="fa fa-check" style="color: green;"></i> Accetta
                                    </td>
                                    <td><input type="checkbox" class="checkboxes" name="de-${Lista1.tirocinante.IDTirocinante}-${Lista1.tirocinio.IDTirocinio}" value="2"/> <i
                                                class="fa fa-times" style="color: red;"></i> Declina
                                    </td>
                                </tr>
                                </#if>
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
                </div>
            </div>
                </#if>
            </#if>

            <h1 class="mb-0">Richieste Declinate</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Visualizza Tutte le Richieste declinate
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered bg-white table-hover border"
                           id="datatable_3" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>email Tirocinante</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list Lista as Lista2>
                            <#if Lista2.tirocinio.stato == 5>
                            <tr>
                                <td>${Lista2.tirocinante.nome}</td>
                                <td>${Lista2.tirocinante.cognome}</td>
                                <td>${Lista2.userMail}</td>
                            </tr>
                            </#if>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
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
    function initTableAll() {

        var table = jQuery('#datatable_1');

        var oTable = table.dataTable({
            "columns": [{
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
                {
                    "searchable": true,
                    "targets": [0]
                }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    <#if Scaduto??>
        <#if !Scaduto>
    function initTablePendenti() {

        var table = jQuery('#datatable_2');

        var oTable = table.dataTable({
            "columns": [{
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
            "scrollX": true,
            "columnDefs": [  // set default column settings
                {
                    "searchable": true,
                    "targets": [0]
                }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }
        </#if>
    </#if>


    function initTableRifiutati() {

        var table = jQuery('#datatable_3');

        var oTable = table.dataTable({
            "columns": [{
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
            "scrollX": true,
            "columnDefs": [  // set default column settings
                {
                    "searchable": true,
                    "targets": [0]
                }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }


    initTableAll();
    <#if Scaduto??>
    <#if !Scaduto>
    initTablePendenti();
    </#if>
    </#if>
    initTableRifiutati();
    <#if Scaduto??>
    <#if !Scaduto>
    $("tbody#checkbox tr td input[type=checkbox]").click(enable_cb);


    function enable_cb() {
        if (this.checked) {
            console.log(this);
            $(this).closest("tr").children().children().attr("disabled", "true").addClass('grey');
            $(this).removeAttr("disabled").next().removeClass('grey');

        } else {
            $(this).closest("tr").children().children().removeAttr("disabled");
            $(this).closest("tr").children().children().removeClass('grey');
        }
    }
    </#if>
    </#if>

</script>

</body>
</html>