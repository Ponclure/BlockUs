execute as @a if data entity @s {RootVehicle:{}} run tag @s add sitting

execute as @a[tag=sitting] unless data entity @s {RootVehicle:{}} run playsound minecraft:spawn master @s
execute as @a[tag=sitting] unless data entity @s {RootVehicle:{}} run tag @s remove sitting
