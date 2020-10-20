execute as @a[x=-270,y=201,z=-346,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
clear @a[x=-270,y=201,z=-346,dx=6,dy=3,dz=1] netherite_pickaxe
tp @a[x=-270,y=201,z=-346,dx=6,dy=3,dz=1] @e[tag=weapons,tag=clear_asteroids,limit=1]

execute as @e[tag=weapons,tag=clear_asteroids,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/weapons/clear_asteroids
