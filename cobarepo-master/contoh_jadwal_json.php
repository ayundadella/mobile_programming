<?php

include("config.php");



$sql = "SELECT * FROM jadwal_sholat";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array('id' => $row['id_jadwal'],
    'shubuh' => $row['shubuh'],
    'dhuha' => $row['dhuha'],
    'dhuhur' => $row['dhuhur'],
    'ashar' => $row['ashar'],
    'maghrib' => $row['maghrib'],
    'isha' => $row['isha']
    
));
}
echo json_encode(array("result" => $result));
?>



