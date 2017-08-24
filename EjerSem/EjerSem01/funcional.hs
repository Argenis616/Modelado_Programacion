module Semanal01 where
    --------------------------------------------------------------------------------
    -- Universidad Nacional Autónoma de México, Facultad de Ciencias              --
    -- Modelado y Programación 2018-1                                             --
    -- Actividad Semanal 01: Paradigmas de Programación                           --
    --                                                                            --
    -- Observación:                                                               --
    --  Para ejecutar la función abrir la terminal:                               --
    --  ghci funcional.hs                                                         --
    --  combinaciones n r                                                         --
    --  Profesor José de Jeús Galaviz Casas                                       --
    --  Ayudante José Ricardo Rodriguéz Abreu                                     --
    -- Ayud.Lab. Norma Verónica Trinidad Hernández                                --
    --------------------------------------------------------------------------------

-- Función para calcular el factorial de un número entero
  factorial :: Integer -> Integer
  factorial 0 = 1
  factorial 1 = 1
  factorial n = n * factorial (n-1)

-- Función para calcular las combinacione de n en r
  combinaciones :: Integer -> Integer -> Integer
  combinaciones n r = factorial n `div`(factorial (n-r) * factorial r)
