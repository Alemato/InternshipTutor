<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload</title>
</head>
<body>
<div style="text-align: center;">
    <h1>File Upload</h1>

    <form method="post" action="/provaUpload"
          enctype="multipart/form-data">
        Select file to upload: <input type="file" name="filetoupload" size="60" /><br />
        <br /> <input type="submit" value="Upload" />
    </form>
</div>
</body>
</html>