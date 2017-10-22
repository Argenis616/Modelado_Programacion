#include <iostream>
#include <string>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

struct Byte1 {
	unsigned int b0:1;
	unsigned int b1:1;
	unsigned int b2:1;
	unsigned int b3:1;
	unsigned int b4:1;
	unsigned int b5:1;
	unsigned int b6:1;
	unsigned int b7:1;
}bits_imagen, bits_texto;

bool isBMP(FILE * fd)
{
    fseek(fd,0, SEEK_SET);
    if (fgetc(fd) != 'B')
        return false;
    if (fgetc(fd) != 'M')
        return false;
    return true;
}
bool is24(FILE *fd)
{
    fseek(fd,27, SEEK_SET);
    char caracter;
    caracter = fgetc(fd);
    if (caracter == 24)
        return true;
    caracter = fgetc(fd);
    if (caracter == 24)
        return true;
    return false;
}
bool isJPG(FILE * fd)
{
    fseek(fd,0, SEEK_SET);
    if (fgetc(fd) != 0xFF)
        return false;
    if (fgetc(fd) != 0xD8)
        return false;
    if (fgetc(fd) != 0xFF)
        return false;
    return true;
}

int codificar(FILE *fd_imagen, FILE *fd_nimagen, FILE *fd_texto, int pos)
{
	fseek(fd_imagen, 0, SEEK_SET);
	fseek(fd_nimagen, 0, SEEK_SET);
	fseek(fd_texto, 0, SEEK_SET);
	int byte_imagen;
	int byte_texto;
	for (int i  = 0; i<pos; i++)
	{
		byte_imagen = fgetc(fd_imagen);
		fputc(byte_imagen,fd_nimagen);
	}
	cout << endl;
	byte_texto = 178;
	for (int i= 0; i<8; i++)
	{
		memcpy(&bits_texto, &byte_texto,1);
		byte_imagen = fgetc(fd_imagen);
		memcpy(&bits_imagen, &byte_imagen,1);
		bits_imagen.b0 = bits_texto.b0;
		byte_texto >>=1;
		memcpy(&byte_imagen, &bits_imagen,1);
		fputc(byte_imagen,fd_nimagen);		
	}
	while(!feof(fd_texto))
	{
		byte_texto = fgetc(fd_texto);
	    if (byte_texto == 0xFFFFFFFF) break;
		for(int i= 0; i<8; i++)
		{
			memcpy(&bits_texto, &byte_texto,1);
			byte_imagen = fgetc(fd_imagen);
			memcpy(&bits_imagen, &byte_imagen,1);
			bits_imagen.b0 = bits_texto.b0;
			byte_texto >>=1;
			memcpy(&byte_imagen, &bits_imagen,1);
			fputc(byte_imagen,fd_nimagen);
		}	
	}
	
	byte_texto = 178;
	for (int i= 0; i<8; i++)
	{
		memcpy(&bits_texto, &byte_texto,1);
		byte_imagen = fgetc(fd_imagen);
		memcpy(&bits_imagen, &byte_imagen,1);
		bits_imagen.b0 = bits_texto.b0;
		byte_texto >>=1;
		memcpy(&byte_imagen, &bits_imagen,1);
		fputc(byte_imagen,fd_nimagen);		
	}
	//Copiar el resto de la imagen
	while(!feof(fd_imagen))
	{
		byte_imagen = fgetc(fd_imagen);
		fputc(byte_imagen,fd_nimagen);
	}
	return 0;
	
}

bool isCodificada(FILE *fd, int pos)
{
    int byte_imagen;
    int byte_texto=0;
    int caracter=0;
    fseek(fd,pos, SEEK_SET);
    for (int i= 0; i<8; i++)
    {
        byte_imagen = fgetc(fd);
        memcpy(&bits_imagen, &byte_imagen,1);
        bits_texto.b7 = bits_imagen.b0;
        if (i != 7)
        {
            memcpy(&byte_texto, &bits_texto,1);
            byte_texto >>=1;
            memcpy(&bits_texto, &byte_texto,1);
        }
    }
    memcpy(&byte_texto, &bits_texto,1);
    memcpy(&caracter, &byte_texto,1);
    if (caracter==178)
    return true;
    return false;
}

int decodificar(FILE *fd_imagen, int pos)
{
    int byte_imagen;
    int byte_texto=0;
    int caracter=0;
    bool marca_fin = false;
    fseek(fd_imagen,pos, SEEK_SET);
    while (!marca_fin)
    {
        for (int i= 0; i<8; i++)
        {
            byte_imagen = fgetc(fd_imagen);
            memcpy(&bits_imagen, &byte_imagen,1);
            bits_texto.b7 = bits_imagen.b0;
            if (i != 7)
            {
                memcpy(&byte_texto, &bits_texto,1);
                byte_texto >>=1;
                memcpy(&bits_texto, &byte_texto,1);
            }
        }
        memcpy(&byte_texto, &bits_texto,1);
        memcpy(&caracter, &byte_texto,1);
        if (caracter==178)
        marca_fin = true;
        else
        printf("%c", caracter);
    }
    return 0;
}

int codifica()
{
	string ruta_imagen, ruta_texto, ruta_nimagen;
	bool isbBMP = false, isbJPG = false;
	char caracter;
	FILE *fd_imagen, *fd_texto, *fd_nimagen;
	cout << "Bienvenido al programa, elija un archivo BMP\n";
	cin >> ruta_imagen;
	cout << ruta_imagen << endl;
	const char * ruta_imagen_char = ruta_imagen.c_str();
	fd_imagen = fopen(ruta_imagen_char, "r");
	if (fd_imagen == NULL)
	{
		cout << "No se puede abrir el archivo\n";
		exit(1);
    }
    if (isBMP(fd_imagen)==true)
	{
	    cout << "El archivo de imagen es un archivo BMP\n";
	    isbBMP = true;
	}
	else if (isJPG(fd_imagen)==true)
	{
	    cout << "El archivo de imagen es un archivo JPG\n";
	    isbJPG = true;
	}
	else
	{
	    cout << "El archivo no está soportado actualmente por el programa";
	    exit(1);
	}
	cout << "Introduce el archivo de texto a codificar en la imagen seleccionada\n";
	cin >> ruta_texto;
	cout << ruta_texto << endl;
	const char * ruta_texto_char = ruta_texto.c_str();
	fd_texto = fopen(ruta_texto_char, "r");
	if (fd_texto == NULL)
	{
		cout << "No se puede abrir el archivo\n";
		exit(1);
	}
	caracter = fgetc(fd_texto);
	while(!feof(fd_texto))
	{
	    printf("%c", caracter);
	    caracter = fgetc(fd_texto);
	}
	cout << "Introduzca la ruta de la nueva imagen\n";
	cin >> ruta_nimagen;
	const char * ruta_nimagen_char = ruta_nimagen.c_str();
	fd_nimagen = fopen(ruta_nimagen_char, "w");
	if (fd_nimagen == NULL)
	{
		cout << "No se ha podido crear el fichero\n";
		exit(1);
	}
	if (isbBMP==true)
	{
	    codificar(fd_imagen,fd_nimagen,fd_texto, 54);
	}
	else if (isbJPG==true)
	{
	    codificar(fd_imagen,fd_nimagen,fd_texto, 10);
	}
	fclose(fd_imagen);
	fclose(fd_nimagen);
	fclose(fd_texto);
	return 0;
}
//hola este es la otra parte 



int decodifica()
{
    string ruta_imagen;
    FILE *fd_imagen;
    bool isbBMP = false, isbJPG = false;
    char opcion;
    cout << "Bienvenido al programa, elija un archivo BMP\n";
    cin >> ruta_imagen;
    const char * ruta_imagen_char = ruta_imagen.c_str();
    fd_imagen = fopen(ruta_imagen_char, "r");
    if (fd_imagen == NULL)
    {
        cout << "No se puede abrir el archivo\n";
        exit(1);
    }
    if (isBMP(fd_imagen)==true)
    {
        cout << "El archivo de imagen es un archivo BMP\n";
        isbBMP = true;
        if (isCodificada(fd_imagen, 54)==false)
        {
            cout << "El archivo de imagen no esta codificado\n";
            exit(0);
        }
        else
        {
            cout << "Este archivo de imagen tiene oculto en su interior un texto codificado ¿Quieres leer el texto?(s/n)";
            cin >> opcion;
            if(opcion == 's')
            {
                cout << "===================INICIO DEL TEXTO OCULTO======================\n";
                decodificar(fd_imagen, 62);
                cout << "===================FIN DEL TEXTO OCULTO======================\n";
            }
            else
            exit(0);
        }
    }
    else if (isJPG(fd_imagen)==true)
    {
        cout << "El archivo de imagen es un archivo JPG\n";
        isbJPG = true;
        if (isCodificada(fd_imagen, 10)==false)
        {
            cout << "El archivo de imagen no esta codificadon";
            exit(0);
        }
        else
        {
            cout << "Este archivo de imagen tiene oculto en su interior un texto codificado ¿Quieres leer el texto?(s/n) ";
            cin >> opcion;
            if(opcion == 's')
            {
                cout << "===================INICIO DEL TEXTO OCULTO======================\n";
                decodificar(fd_imagen, 18);
                cout << "===================FIN DEL TEXTO OCULTO======================\n";
            }
            else
            exit(0);
        }
    }
    else
    {
        cout << "El archivo no está soportado actualmente por el programan";
        exit(1);
    }
    fclose(fd_imagen);
    return 0;
}

int main()
{
		char opcion;
		cout << "Elije u para codificar o h para decodificar\n";
			cin >> opcion;
		cout << opcion << endl;
	if(opcion == 'u')
	{
		codifica();
	
	}
	else if(opcion == 'h')
	{
		decodifica();
	}else{
	cout << "no puedes hacer eso xD\n";
	}
}
