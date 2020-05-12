<?php

include("config.php");

	$nama_mahasiswa=$_POST['nama_mahasiswa'];
	$nomer_mahasiswa=$_POST['nomer_mahasiswa'];
	$alamat_mahasiswa=$_POST['alamat_mahasiswa'];


	$sql = "INSERT INTO mahasiswa(nama_mahasiswa, nomer_mahasiswa, alamat_mahasiswa) values('$nama_mahasiswa','$nomer_mahasiswa', '$alamat_mahasiswa')";
	$query = mysqli_query($db, $sql);

	//apakah data berhasil di update
	if($query ) {

	}else{
		//kalau gagal tampilkan pesan 
		die("Gagal menyimpan perubahan...");
	}