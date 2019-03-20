<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Richieste Convenzioni</title>

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
        <li class="active"><a href="gestione-utenza-admin.html"><b>GESTIONE RICHIESTE CONVENZIONE</b></a></li>
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
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar bg-light">
            <div class="side-nav mb-60">
                <ul class="list-group list-group-bordered list-group-noicon uppercase">
                    <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
                    <li class=""><a href="gestione-utenza-admin.html">GESTIONE UTENZA</a></li>
                    <li class="active"><a href="gestione-richieste-convenzioni-admin.html">GESTIONE RICHIESTE CONVENZIONE</a></li>
                    <li class="list-group-item">
                        <a class="dropdown-toggle" href="gestione-tirocinii-admin.html">GESTIONE TIROCINII</a>
                        <ul>
                            <li><a href="ultime-offerte-pubblicate-admin.html">ULTIME OFFERTE PUBBLICATE</a></li>
                            <li class=""><a href="offerte-scadute-admin.html">OFFERTE SCADUTE</a></li>
                            <li class=""><a href="tutte-offerte-pubblicate-admin.html">TUTTE LE OFFERTE PUBBLICATE</a></li>
                        </ul>
                    </li>
                    <li class="list-group-item">
                        <a class="dropdown-toggle" href="gestione-moduli-admin.html">GESTIONE MODULI</a>
                        <ul>
                            <li><a href="richieste-tirocinii-tirocinanti-admin.html">RICHIESTE TIROCINII TIROCINANTI</a></li>
                            <li><a href="richieste-convenzioni-aziendali-admmin.html">RICHIESTE CONVENZIONI AZIENDALI</a>
                            </li>
                            <li><a href="modulo-tirocinio-fine-admin.html">MODULO TIROCINIO FINE</a>
                            </li>
                        </ul>
                    </li>

                    <li class=""><a href="impostazione-account-admin.html">IMPOSTAZIONI ACCOUNT</a></li>
                    </li>
                </ul>
            </div>
        </nav>


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
            <#if WarningSucess??>
                <#if WarningSuccess??>
                    <div class="alert alert-success mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${WarningSuccess}
                    </div>
                </#if>
            </#if>
            <#if WarningInsuccess??>
                <#if WarningInsuccess??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${WarningInsuccess}
                    </div>
                </#if>
            </#if>
            <h3>Lista Richieste</h3>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Richieste di Convenzionamento pendenti
                </div>
                <div class="card-body">
                    <div class="table-responsive">

                        <table class="table table-striped table-bordered table-hover" id="datatable_1" width="100%"
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
                                <th>Modifica Richiesta</th>
                                <th>Carica PDF Convenzione</th>
                                <th>Accetta Richiesta</th>
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
                                <th>Visualizza Richiesta</th>
                                <th>Modifica Richiesta</th>
                                <th>Carica PDF Convenzione</th>
                                <th>Accetta Richiesta </th>
                                <th>Declina richiesta</th>
                            </tr>
                            </tfoot>
                            <tbody>
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

                                    <td>${azienda.createDate?date?string("yyyy-MM-dd")}</td>
                                    <td>
                                        <a type="button" href="/#" class="btn btn-primary"> Visualizza</a>
                                    </td>
                                    <td>
                                        <a type="button" href="/Modifica-Convenzione?IDAzienda=${azienda.IDAzienda}" class="btn btn-secondary"> Modifica</a>
                                    </td>
                                    <td>
                                        <#if (azienda.PathPDFConvenzione)??>
                                            <h4>Azione non disponibile</h4>
                                            <#else>
                                                <form action="/#" method="post" enctype="multipart/form-data">
                                                    <input type="hidden" name="IDAzienda" value="${azienda.IDAzienda}">
                                                    <input type="file" name="PDFConvenzione">
                                                    <button type="submit" class="btn btn-primary">Carica</button>
                                                </form>
                                        </#if>

                                    </td>

                                    <td>

                                        <form action="/Accetta"  method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="stato" value="rifiuta">
                                            <input type="hidden" name="IDAzienda" value="${azienda.IDAzienda}">
                                            <input  type="submit" class="btn btn-green" value="Accetta">
                                        </form>
                                    </td>
                                    <td>
                                        <form action="/accetta" method="post">
                                            <input type="hidden" name="stato" value="declina">
                                            <input type="hidden" name="IDAzienda" value="${azienda.IDAzienda}">
                                            <input  type="submit" class="btn btn-red" value="Declina">
                                        </form>

                                    </td>
                                </tr>
                            </#list>

                            </tbody>
                        </table>

                        <footer class="text-center text-sm-right mt-25 ">
                        </footer>
                    </div>
                </div>
            </div>

            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2>Convenzioni Aziendali Stipulate</h2>
            <h3>Lista Convenzioni</h3>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Convenzioni Stipulate
                </div>
                <div class="card-body" style="width: 100%">
                    <table class="table table-striped table-bordered table-hover" id="datatable_2" cellspacing="0">
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
                            <th>Visualizza Convenzione</th>
                            <th>Modifica Convenzione</th>
                            <th>Carica PDF convenzione</th>
                            <th>Elimina Convenzione</th>
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
                            <th>Visualizza Convenzione</th>
                            <th>Modifica Convenzione</th>
                            <th>Carica PDF convenzione</th>
                            <th>Elimina Convenzione</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <#list AziendaAttive as azienda>
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

                                <td>${azienda.createDate}</td>
                                <td>
                                    <a type="button" href="/#" class="btn btn-primary"> Visualizza</a>
                                </td>
                                <td>
                                    <a type="button" href="/#" class="btn btn-secondary"> Modifica</a>
                                </td>
                                <td>
                                    <#if (azienda.PathPDFConvenzione)??>
                                        <h4>Azione non disponibile</h4>
                                    <#else>
                                        <form action="/#" method="post" enctype="multipart/form-data">
                                            <input type="hidden" name="IDAzienda" value="${azienda.IDAzienda}">
                                            <input type="file" name="PDFConvenzione">
                                            <button type="submit" class="btn btn-primary">Carica</button>
                                        </form>
                                    </#if>
                                </td>
                                <td>
                                    <form action="#" method="post">
                                        <input type="hidden" name="stato" value="declina">
                                        <input type="hidden" name="IDAzienda" value="${azienda.IDAzienda}">
                                        <input  type="submit" class="btn btn-red" value="Elimina">
                                    </form>

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


<#include "../importScript.ftl">

<!-- Script page -->
<script src="plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.js"></script>
<script src="plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTablePendenti() {

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
                "width": "7%",
                "orderable": false
            }, {
                "width": "7%",
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

    function initTableUltime() {

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

    initTablePendenti();
    initTableUltime();
    $("tr td input[type=checkbox]").click(enable_cb);


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
</script>
</body>
</html>
