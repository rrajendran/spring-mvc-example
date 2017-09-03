<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--External Styles -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <!-- Internal Styles -->
	<style>
        @media (max-width: 62em) {
            .navbar-nav {
                padding-top: .425rem;
                padding-left: 0.75rem;
            }
            .navbar-nav .nav-item {
                float: none;
            }
            .navbar-brand {
                float: right;
            }
            .navbar-brand,
            .navbar-nav .nav-item {
                display: block;
            }
            .navbar-nav .nav-item + .nav-item {
                margin-left: 0;
            }
            .dropdown-menu {
                position: relative;
                float: none;
            }
        }
    </style>
    <!-- External Scripts -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

    <!-- Internal Scripts -->
	<script type="text/javascript" src="">
	</script>

    <title>Spring MVC Demo</title>


</head>

<body>
   <div class="container-fluid" style="align-content: center;width: 50%">
       <h1>Spring MVC Demo</h1>
       <table class="table">
          <tbody>
            <tr>
              <th scope="row">Timestamp</th>
              <td>${dateTime}</td>
            </tr>
            <tr>
               <th scope="row">Host Name</th>
              <td>${hostName}</td>
            </tr>
            <tr>
               <th scope="row">Session Id</th>
              <td>${sessionId}</td>
            </tr>
            <tr>
               <th scope="row">Page Views</th>
              <td>${count}</td>
            </tr>
          </tbody>
        </table>
    </div>


</body>

</html>
