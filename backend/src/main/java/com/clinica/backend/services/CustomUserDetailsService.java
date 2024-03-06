package com.clinica.backend.services;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EnfermeiroRepository enfermeiroRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Medico medico = medicoRepository.findByUsername(username);
        Enfermeiro enfermeiro = enfermeiroRepository.findByUsername(username);

        if (medico != null) {
            return new User(medico.getUsername(), medico.getPassword(), getAuthorities("MEDICO"));
        } else if (enfermeiro != null) {
            return new User(enfermeiro.getUsername(), enfermeiro.getPassword(), getAuthorities("ENFERMEIRO"));
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
    }

    private Set<GrantedAuthority> getAuthorities(String role) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }