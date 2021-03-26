<?php
$value = $_POST["value"];

$jsondata = '{
    "value": "request successfull"
}';

if ($id != null) {
    echo($jsondata);
}
else{
    echo("null value");
}
?>
