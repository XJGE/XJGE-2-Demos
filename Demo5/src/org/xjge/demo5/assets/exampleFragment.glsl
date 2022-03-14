#version 330 core

in vec3 ioColor;

void main() {

    gl_FragColor = vec4(ioColor, 0);
    
}